# Perspektywy App
Technologies: Spring Boot, Spring Security, JWT-based Authentication, MySQL, Hibernate, Swagger OpenAPI, lombok

# Description
Sometimes ideas die before they see the light of day, and some never even surface because their creators fail to find partners for their realization, don't receive support, or don't meet people ready to act. Our application brings together creative creators, ideas, and performers to enable the effective realization of young people's dreams and become a source of motivational and substantive support.
The main element of the application is an interactive map where users can browse profiles of people open to collaboration. The application offers three main functionalities:
- Communication with a mentor for development in the right direction.
- The ability to join existing projects or create new ones to expand knowledge and skills.
- Creating groups to participate together in IT-related events.

# Security
Expiration time for access token is 5 minutes, for refresh token is 1 hour. If your access token is expired, send a refresh token to get a new one. If the refresh token is expired too, you need to login again. After logout your refresh-token will be deleted from DB, and It is not possible to get access tokens using them, but your access token will be active for several minutes until its expiration time is over. If you try to get a new access token, the service returns a new access token and refresh token. Both of them will be new. Don’t try to save them in cookies (because of their size, it is about 4KB), access token is very heavy for this, also sometimes Chrome doesn’t allow saving JWT in cookies, it is bad practice because of CSRF attack.
With access token you can reach any service, it will be parsed by Spring Security. To get a refresh token ask Authentication Service.


# API documentation
https://docs.google.com/document/d/1aye47CurAEzmC-NBQReB79Y4bdFb_DwrqadBclUrSxc/edit#heading=h.30j0zll

# Postman Collection
https://www.postman.com/navigation-cosmologist-63510614/workspace/my/collection/28458819-319f4c1c-e895-4d02-a50b-57afe328a831?action=share&creator=28458819&active-environment=28458819-54671117-24ce-49c5-a16c-ef25151cebee

# Swagger OpenAPI
http://localhost:9091/swagger-ui/index.html#/


# Spring Dependencies
![image](https://github.com/alexlklim/PerspektywyApp/assets/91628959/6ce2eb0f-f66e-4d8b-ac3d-7961abeeb293)


# Database
https://my.vertabelo.com/doc/6dqQqBQTn5UgesMsIZ6NYNjNlmxiDxpN

![image](https://github.com/alexlklim/PerspektywyApp/assets/91628959/3c703ce3-ca44-4c2d-a598-c5843a3e5faa)

# Database Configuration
![image](https://github.com/alexlklim/PerspektywyApp/assets/91628959/40f9d865-696d-4dc8-8f89-609bee6dbec1)

