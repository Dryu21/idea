module SessionsHelper

# 渡されたユーザーでログインする
 def log_in(student)
   session[:student_id] = student.id
 end

 # ユーザーのセッションを永続的にする
   def remember(student)
     student.remember
     cookies.permanent.signed[:student_id] = student.id
     cookies.permanent[:remember_token] = student.remember_token
   end

# 現在ログイン中のユーザーを返す (いる場合)
 def current_student
   if (student_id = session[:student_id])
     @current_student ||= Student.find_by(id: student_id)
   elsif (student_id = cookies.signed[:student_id])
     student = Student.find_by(id: student_id)
     if student && student.authenticated?(cookies[:remember_token])
       log_in student
       @current_student = student
     end
   end
 end

 # ユーザーがログインしていればtrue、その他ならfalseを返す
 def logged_in?
   !current_student.nil?
 end

 # 永続的セッションを破棄する
 def forget(student)
   student.forget
   cookies.delete(:student_id)
   cookies.delete(:remember_token)
 end

 # 現在のユーザーをログアウトする
  def log_out
    forget(current_student)
    session.delete(:student_id)
    @current_student = nil
  end

end
