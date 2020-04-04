# Для работы приложения потребуется postgresql
#  В нем нужно создать бд c названием postgres 
#  Логин  postgres 
#  Пароль 123 
 
 #Port
  8080
  
  #Create
  
  -Url: /create
  
  Type: Get
  
  Desc: create new task
  
  ##Params
  
  Name | Desc
  ------------- | -------------
  nicName | Username
  name | Task name
  text | Task text
  
  #Get
  
  Url: /get
  
  Type: Get
  
  Desc: getting all information on a task through its id
  
  ##Params
  Name | Desc
  ------------- | -------------
  id|Task id 
  
  #Сhange
  
  Url: /change
  
  Type: Get
  
  Desc: set new task status
  
  ##Params
  Name | Desc
  ------------- | -------------
  id| Task id 
  status | New task status
  
  #Find undone
  
  Url: /find/undone
  
  Type: Get
  
  Desc: Find all undone tasks
  
  #Find done
  
  Url: /find/done
  
  Type: Get
  
  Desc: Find all done tasks
  
  #Find arhiv
  
  Url: /find/arhiv
  
  Type: Get
  
  Desc: Find all arhiv tasks
  
  #Find date
  
  Url: /find/date
  
  Type: Get
  
  Desc: Find all tasks created in a given period of time
  
  ##Params
  
  Name | Desc
  ------------- | -------------
  from | dd-MM-yyyy
  to | dd-MM-yyyy
