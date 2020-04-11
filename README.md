# Для работы приложения потребуется postgresql

#  В нем нужно создать бд c названием postgres и бд с названием asd

#  Логин  postgres 

#  Пароль 123 
 
 # Port
 service1 8080
 service2 8081
  
  # Create service 1
  
  Url: /create
  
  Type: Post
  
  Desc: create new task
  
  ## Params
  
  Name | Desc
  ------------- | -------------
  nicName | Username
  name | Task name
  text | Task text
  
  # Get service 1
  
  Url: /get
  
  Type: Get
  
  Desc: getting all information on a task through its id
  
  ## Params
  Name | Desc
  ------------- | -------------
  id|Task id 
  
  # Сhange service 2
  
  Url: /change
  
  Type: Put
  
  Desc: set new task status
  
  ## Params
  Name | Desc
  ------------- | -------------
  id| Task id 
  status | New task status
  
  # Find undone service 1
  
  Url: /find/undone
  
  Type: Get
  
  Desc: Find all undone tasks
  
  # Find done service 1
  
  Url: /find/done
  
  Type: Get
  
  Desc: Find all done tasks
  
  # Find arhive service 1
  
  Url: /find/arhive
  
  Type: Get
  
  Desc: Find all arhive tasks
  
  # Find date service 1
  
  Url: /find/date
  
  Type: Get
  
  Desc: Find all tasks created in a given period of time
  
  ## Params
  
  Name | Desc
  ------------- | -------------
  from | dd-MM-yyyy
  to | dd-MM-yyyy
