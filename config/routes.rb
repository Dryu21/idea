Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  root 'homes#index'

  get  '/signup',  to: 'users#new'

  get  '/studentsignup',  to: 'students#new'
  post '/studentsignup',  to: 'students#create'

  get    '/login',   to: 'sessions#new'
  post   '/login',   to: 'sessions#create'
  delete '/logout',  to: 'sessions#destroy'

  get  '/businessmensginup', to: 'businessmens#new'
  resources :students

end
