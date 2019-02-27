require 'test_helper'

class SiteLayoutTest < ActionDispatch::IntegrationTest
  test "layout links" do
      get root_path
      assert_template 'homes/index'
      assert_select "a[href=?]", root_path, count: 1
      assert_select "a[href=?]", signup_path, count: 1
      get signup_path
      assert_template 'users/new'
      assert_select "a[href=?]", studentsignup_path, count: 1
      assert_select "a[href=?]", businessmensginup_path, count: 1
    end
end
