require 'test_helper'

class StudentsControllerTest < ActionDispatch::IntegrationTest

  def setup
   @user = students(:michael)
   @other_user = students(:archer)
  end

  test "should get new" do
    get studentsignup_path
    assert_response :success
  end

  test "should redirect edit when not logged in" do
   get edit_student_path(@user)
   assert_not flash.empty?
   assert_redirected_to login_url
 end

 test "should redirect update when not logged in" do
   patch student_path(@user), params: { student: { name: @user.name,
                                             email: @user.email } }
   assert_not flash.empty?
   assert_redirected_to login_url
 end

end
