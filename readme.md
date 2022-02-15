# Pet Clinic Application using Spring Boot 

### About the project

**PetClinic App** was developed for veterinary operations. You can become a member of the system and then log in. 
It has a role-based structure. You can add, update, delete the owner or animal according to the authority you have. 
The animal or the owner of the animal can be searched by entering the name information and can be examined 
if the relevant records are found.

Tech Stack:

* [Spring Boot](#) - [JPA / Hibernate](#) - [Spring Security](#)
* [Thymeleaf](#) - [H2 Database](#) - [Docker](#)
* [Git](#) - [JUnit5](#) - [Java 11](#)

### Project run

We can run two different ways:

Login Info:
For admin
* Username: admin
* Password: 123
* 
For user
* Username: user
* Password: 123

### with Docker

1. go to this github adress git clone https://github.com/AbbasSAFAROV/pet-clinic-with-springboot-thymeleaf
2. docker build -t [tagName:version] [dockerfilePath] .
3. docker run --name [containerName] -p 8080:80 [image]
4. this my image you can run : docker run --name petApp -p 8080:80 abbas1997/petclinicapplication:0.1




### with Maven

1. go to this github adress git clone https://github.com/AbbasSAFAROV/pet-clinic-with-springboot-thymeleaf
2. mvn clean install
3. mvn springboot:run 

> `http://localhost:80` will run that port

## HTTP Client Structure

|      Controller       | Metot  |            Adres            |                  Description                   |
| :-------------------: | :----: | :-------------------------: | :-----------------------------------------: |
|  **UserController**   |  GET   |   localhost:8080/users      |        Will List All users(admin,veterinary)|
|                       |  GET   |  localhost:8080/users/1     |        will get user with id:1              |
|                       |  POST  |   localhost:8080/users      |             create user                     |
|                       |  PUT   |  localhost:8080/users/1     |       will update user with id:1            |
|                       | DELETE |  localhost:8080/users/1     |         will delete user with id:1          |
|  **OwnerController**  |  GET   |   localhost:8080/owners     |         Will List All owners                |
|                       |  GET   |  localhost:8080/owners/1    |         will get owner with id:1            |
|                       |  POST  |  localhost:8080/owners      |                owner user                   |
|                       |  PUT   |  localhost:8080/owners/1    |        will update owner with id:1          |
|                       | DELETE |  localhost:8080/owners/1    |          will delete user with id:1         |
| **PetController**     |  GET   |  localhost:8080/pets        |          Will List All pets                 |
|                       |  GET   | localhost:8080/pets/1       |          will get pet with id:1             |
|                       |  POST  |  localhost:8080/pets        |               Create Pet                    |
|                       |  PUT   | localhost:8080/pets/1       |         will update pet with id:1           |
|                       | DELETE | localhost:8080/pets/1       |           will delete pet with id:1         |


