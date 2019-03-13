ENV['RAILS_ENV'] ||= 'test'
require_relative '../config/environment'
require 'rails/test_help'

class ActiveSupport::TestCase
  # Setup all fixtures in test/fixtures/*.yml for all tests in alphabetical order.
  fixtures :all
  # テストユーザーがログイン中の場合にtrueを返す
   def is_logged_in?
     !session[:student_id].nil?
   end
  # Add more helper methods to be used by all tests here...
end

class ActionDispatch::IntegrationTest

  # テストユーザーとしてログインする
  def log_in_as(student, password: 'password', remember_me: '1')
    post login_path, params: { session: { email: student.email,
                                          password: password,
                                          remember_me: remember_me } }
  end

end
