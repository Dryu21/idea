require 'test_helper'

class StudentsEditTest < ActionDispatch::IntegrationTest

  def setup
     @user = students(:michael)
   end

   test "unsuccessful edit" do
     log_in_as(@user)
     get edit_student_path(@user)
     assert_template 'students/edit'
     patch student_path(@user), params: { student: { name:  "",
                                        email: "user@invalid",
                                        password:              "foo",
                                        password_confirmation: "bar",
                                        phonenumber: "09099585568",
                                        belonging:"大学生",
                                        schoolname: "芝浦工業大学",
                                        profile: "HelloWorld"} }

     assert_template 'students/edit'
  end

   test "successful edit with friendly forwarding" do
    get edit_student_path(@user)
    log_in_as(@user)
    assert_redirected_to edit_student_url(@user)
    name  = "Foo Bar"
    email = "foo@bar.com"
    patch student_path(@user), params: { student: { name:  name,
                                       email: email,
                                       password:              "",
                                       password_confirmation: "",
                                       phonenumber: "09099585568",
                                       belonging:"大学生",
                                       schoolname: "芝浦工業大学",
                                       profile: ""} }

    assert_redirected_to @user
    @user.reload
    assert_equal name,  @user.name
    assert_equal email, @user.email
  end


end
