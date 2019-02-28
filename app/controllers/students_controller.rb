class StudentsController < ApplicationController
  def show
    @student=Student.find(params[:id])
  end

  def new
    @student=Student.new
  end

  def create
    @student = Student.new(student_params)    # 実装は終わっていないことに注意!
    if @student.save
      flash[:success] = "ようこそIDEAへ"
      redirect_to @student
    else
      render 'new'
    end
  end

  private

    def student_params
      params.require(:student).permit(:name, :email, :password, :password_confirmation)
    end
end
