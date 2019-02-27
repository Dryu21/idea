require 'test_helper'

class StudentsControllerTest < ActionDispatch::IntegrationTest
  test "should get new" do
    get studentsignup_path
    assert_response :success
  end
end
