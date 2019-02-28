module SessionsHelper

# 渡されたユーザーでログインする
 def log_in(student)
   session[:student_id] = student.id
 end

# 現在ログイン中のユーザーを返す (いる場合)
 def current_student
    if session[:student_id]
      @current_student ||= Student.find_by(id: session[:student_id])
    end
 end

 # ユーザーがログインしていればtrue、その他ならfalseを返す
 def logged_in?
   !current_student.nil?
 end

 # 現在のユーザーをログアウトする
  def log_out
    session.delete(:student_id)
    @current_student = nil
  end
end
