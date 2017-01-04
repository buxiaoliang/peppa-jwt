# peppa services
peppa services examples

## Startup
* create a database named "peppa"
* java -jar peppa-web/build/libs/peppa-web-MAIN-SNAPSHOT.war -Dserver.port=8080

## Authentication
* Form authentication
* Basic authentication

## How to run
* http://localhost:8080/registration to registration a user
* http://localhost:8080/login to log in

## Rest
* http://localhost:8080/rest/users with baisc authentication using postman

## Build
gradlew build

## Gradle wrapper generation
gradle wrapper --gradle-version 2.13

# References
* https://spring.io/guides/gs/securing-web/#initial
* https://spring.io/guides/gs/gradle/