# Springboot Concepts


A framework is a chunk of code written on top of a language's core library to solve common problems  

spring framework  
spring boot is top of that spring framework

Spring boot is highly configurable
Its tales more effort

## Maven
Transitive dependency

mvnw [options] [<goal(s)>] [<phase(s)>]

mvnw clean defulat site

clean - Remove temporary directories and files.

default - Where the most useful goals live.

sit - Where documentation is generated.

### mvnw clean
pre-clean - Hook for before cleaning.

clean - Does the actual cleaning

post-clean - Hook for after cleaning

### mvnw [default]
compile - Compile your conde into bytecode

test - Runs unit tests

package - Creates a jar or war file

verify - Runs checks & integration tests


### Maven workflow
compile - quick to compile code

clean test - clean and run the tests

clean package or clean verify - use it before push

cd target
java -jar springbasicmvn-0.0.1-SNAPSHOT.jar

### Maven Spring Boot Plugin
spring-boot:run


## Layers
### Persistence layer
To  handle database query  - Entities -> Repositories -> Database  
CRUD  - Create Read Update Delete  
Spring Data JPA, Spring JDBC, Database Driver, ex: Postgres SQL

### Service Layer
Connect between persistnece and services
### Presentation layer
Present data to rest or ui and expose to outer world


## Inversion of Control - Dependency Injection
## Introduction to Beans
## @Component
## @Service
## @SpringBootApplication
## @Configuration
## @ComponentScan
## @EnableAutoConfiguration

## Config Files
Common Application Properties - https://docs.spring.io/spring-boot/appendix/application-properties/index.html

application. properties  
server.port=8081

application.yml  
server:
    port: 8081

## Environment Variables
It can set it run configuration in intellij  
SERVER_PORT=8081

It can also run through git bash command line  
SERVER_PORT=8200 ./mvnw spring-boot:run

or  
export=SERVER_PORT=8200  
./mvnw spring-boot:run

See config example in feature/configuration-and-properties

## Database Layers

 ![Database Layers](src/main/resources/images/img.png)

# Connect H2 Database
datasource:  
    url: jdbc:h2:mem:testdb  
    driverClassName: org.h2.Driver  
    username: sa  
    password: password  

# Connect to Postgres SQL
Need to install docker 
Add docker-compose.yml file and add the postgresql database details
Start the postgresql by docker-compose up
Start the spring boot application


## Initialize DB schema
Add schema.sql and db.sql files  
Add mode always true in application yml file  

```
spring: 
 sql:  
  init:  
   mode: always  
```

## JDBC Template setup
JDBC template config used

### What is DAO?
Data Access Object  
### Create DAO in TEST
### Read One DAO
### Integration Testing
#### Find Many
### Full Update
### Delete

## JPA setup
Add the jpa in pom.xml  

### Create Entities

Start docker using docker-compose up. If docker has already configured then remove using docker-compose rm  
s
Add @Entity and @Table(name = "authors") annotation to pojo class to automatically convert pojo class to table in database.  

### Hibernate Auto DDL
Add the following in application.yml file 
```
spring:
 jpa:  
  hibernate:  
   ddl-auto: update  
```

### Create and Read One
### Find all
### Delete data
### Custom query
### HQL

## Jackson
Java object to jackson is marshalling  
jackson to Java object is unmarshalling  

### java object to JSON
### Json to Java Object
### Rename Json Properties
### JSON Ignore

### Rest API
### Create Author Rest end point
### Create Book Rest end point
### Get Author
### Get Books
### Update Author
### Update Books
### Get List of Author
### Get List of Books
### Author Read One
### Book Read One
### Author Full Update
### Book Full Update
### Author Partial Update
### Book Partial Update
### Author Delete
### Delete Book

### Nested object - ModelMapper
### Pagination

## Deployment
Add DockerFile  
mvn clean package  
docker build . -t dreamzlancer/books  
docker image ls  
docker-compose up --build  

The docker-compose used for multi container run
The docker run used for single container

## Postman Collection
