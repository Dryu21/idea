class Student < ApplicationRecord
  before_save { self.email = email.downcase }
  validates :name, presence: true, length: { maximum: 50 }
  VALID_EMAIL_REGEX = /\A[\w+\-.]+@[a-z\d\-]+(\.[a-z\d\-]+)*\.[a-z]+\z/i
  validates :email, presence: true, length: { maximum: 255 },
   format: { with: VALID_EMAIL_REGEX },
   uniqueness: { case_sensitive: false }
  validates :password, presence: true, length: { minimum: 6 }
  has_secure_password
  validates :belonging, presence: true
  validates :schoolname, presence: true, length: { maximum: 50 }
  VALID_PHONE_REGEX = /\A\d{10}$|^\d{11}\z/
  validates :phonenumber, format: { with: VALID_PHONE_REGEX }

  # 渡された文字列のハッシュ値を返す
 def Student.digest(string)
   cost = ActiveModel::SecurePassword.min_cost ? BCrypt::Engine::MIN_COST :
                                                 BCrypt::Engine.cost
   BCrypt::Password.create(string, cost: cost)
 end

end
