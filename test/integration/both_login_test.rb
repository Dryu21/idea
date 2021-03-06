require 'test_helper'

class BothLoginTest < ActionDispatch::IntegrationTest
  def setup
    @student = students(:michael)
  end

   test "login with valid information followed by logout" do
     get login_path
     post login_path, params: { session: { email:    @student.email,
                                           password: 'password' } }
     assert is_logged_in?
     assert_redirected_to @student
     follow_redirect!
     assert_template 'students/show'
     assert_select "a[href=?]", login_path, count: 0
     assert_select "a[href=?]", logout_path
     assert_select "a[href=?]", student_path(@student)
     delete logout_path
     assert_not is_logged_in?
     assert_redirected_to root_url
     delete logout_path
     follow_redirect!
     assert_select "a[href=?]", login_path
     assert_select "a[href=?]", logout_path,      count: 0
     assert_select "a[href=?]", student_path(@student), count: 0
   end

end
