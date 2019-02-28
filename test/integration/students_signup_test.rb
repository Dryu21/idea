require 'test_helper'

class StudentsSignupTest < ActionDispatch::IntegrationTest

  test "invalid signup information" do
    get studentsignup_path
    assert_no_difference 'Student.count' do
      post studentsignup_path, params: { student: { name:  "",
                                         email: "user@invalid",
                                         password:              "foo",
                                         password_confirmation: "bar" } }
    end
    assert_template 'students/new'
  end
  test "valid signup information" do
    get studentsignup_path
    assert_difference 'Student.count', 1 do
      post studentsignup_path, params: { student: { name:  "Example User",
                                         email: "user@example.com",
                                         password:              "password",
                                         password_confirmation: "password" } }
    end
    follow_redirect!
    assert_template 'students/show'
    assert_not flash.empty?
  end
end
