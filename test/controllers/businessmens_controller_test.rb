require 'test_helper'

class BusinessmensControllerTest < ActionDispatch::IntegrationTest
  test "should get new" do
    get businessmensginup_path
    assert_response :success
  end

end
