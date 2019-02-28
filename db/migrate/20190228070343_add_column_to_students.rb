class AddColumnToStudents < ActiveRecord::Migration[5.2]

  def change
    add_column :students, :phonenumber, :string
    add_column :students, :belonging, :string
    add_column :students, :schoolname, :string
    add_column :students, :profile, :text
  end
end
