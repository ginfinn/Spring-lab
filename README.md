Для работы приложения потребуется postgresql
 в нем нужно поднять бд c названием postgres
 логин postgres
 пароль 123
 запросы :
 http://localhost:8080/create?nicName=имяпользователя&name=имязадачи&text=текстзадачи создает новую задачу в поле 
 http://localhost:8080/get?id=idзадания      получение всей информации  по задачи через ее id 
 http://localhost:8080/change?id=idзадания&status=новыйстатус изменяет статус задания
 http://localhost:8080/find/undone находит все невыполненные задания
 http://localhost:8080/find/done находит все выполненные задания
 http://localhost:8080/find/arhiv находит все архивированные задания
 http://localhost:8080/find/date?from=dd-MM-yyyy&to=dd-MM-yyyy находит все задания созданные в заданный промежуток временни

 