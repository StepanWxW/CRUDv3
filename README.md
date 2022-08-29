
# Задание
Необходимо реализовать консольное CRUD приложение, которое взаимодействует с БД и позволяет выполнять все CRUD операции над сущностями:

Writer (id, firstName, lastName, List posts, Region region)

Post (id, content, created, updated, PostStatus)

Region (id, name)

PostStatus(enum ACTIVE, DELETED)

Требования :

Придерживаться шаблона MVC (пакеты model, repository, service, controller, view)

Для миграции БД использовать https://www.liquibase.org/

Сервисный слой приложения должен быть покрыт юнит тестами (junit, mockito).

Для импорта библиотек использовать Maven

Результатом выполнения проекта должен быть отдельный репозиторий на github, с описанием задачи, проекта и инструкцией по локальному запуску проекта.

Технологии : Java, MySQL, JDBC, Maven, Liquibase, JUnit, Mockito

### Решение

# Для работы вам понадобиться скачать и установить MySQL
* Зайти в пакет util класс ConnectMySQL и указать:
1. Порт (по умолчанию он 3306) в MYSQL_URL
2. Ваше имя пользователя в MYSQL_USERNAME
3. Ваш пароль в MYSQL_PASSWORD

#  Настройка Luquibase:
1. Скачать luquibase https://www.liquibase.org/download
2. Для работы с MySQL требуется скачать драйвер JDBS  в формате JAR и поместить в папку liquibase\lib . JAR можно скачать здесь https://dbschema.com/jdbc-driver/MySql.html
3. В командной строке перейти в папку с проектом src/main/java/resources/ 
<br/> Ввести команду liquibase --changeLogFile=changelog.xml update , затем "s".

Все должно работать.

# Полная реализация тестов будет в следующей версии 4.0