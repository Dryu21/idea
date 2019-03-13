class StudentsController < ApplicationController
 before_action :logged_in_student, only: [:edit, :update]
 before_action :correct_student,   only: [:edit, :update]
  def show
    @student=Student.find(params[:id])
  end

  def new
    @student=Student.new
  end

  def create
    @student = Student.new(student_params)    # 実装は終わっていないことに注意!
    if @student.save
      log_in @student
      flash[:success] = "ようこそIDEAへ"
      redirect_to @student
    else
      render 'new'
    end
  end

  def edit
    @student=Student.find(params[:id])
  end

  def update
    @student = Student.find(params[:id])
    if @student.update_attributes(student_params)
      redirect_to @student
    else
      render 'edit'
    end
  end

  private

    def student_params
      params.require(:student).permit(:name, :email, :password, :password_confirmation, :phonenumber, :belonging, :schoolname, :profile)
    end

    # beforeアクション

    # ログイン済みユーザーかどうか確認
    def logged_in_student
      unless logged_in?
        store_location
        flash[:danger] = "Please log in."
        redirect_to login_url
      end
    end

    # 正しいユーザーかどうか確認
    def correct_student
      @student = Student.find(params[:id])
      redirect_to(root_url) unless current_student?(@student)
    end
end
