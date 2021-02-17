# Petvet

Web application made using Spring MVC, Spring Security, Hibernate, HikariCp, Thymeleaf and Bootstrap.

![petvet](https://user-images.githubusercontent.com/65371234/108278917-b2361a80-7173-11eb-88dd-da89f24fcf6a.png)

## Features
- Authentication (Sign up/Sign in)
- Adding new pets
- Setting up appointments for your pets
- Listing vets/pets/appointments
- Canceling appointments
- Removing pets

## Running petvet locally
#### Prerequisites:
- Java 8 or newer
- MySQL 8
- Apache Tomcat 9
#### Steps:
1. Clone the repository
```
git clone https://github.com/milewandowski/petvet.git
```
2. Open the project in your IDE
- IntelliJ ` File -> Open ` and select the petvet pom.xml
- Eclipse (with the m2e plugin) ` File -> Import -> Maven -> Existing Maven project `
3. Set up the Apache Tomcat Server
4. Set up the MySQL Database
- Run SQL scripts from ` src\main\resources\db `
- If you don't want to create the new user from ` src\main\resources\db\user.sql ` please change ` src\main\resources\database.properties `
