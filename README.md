Offer technical test

Getting started :

To build and run the project. You can clone or download the zip of the project.
The project has been developed with Java 14.
So have a look at the jdk 14. 
If you have Java 11 on your computer you will not have any problem either so don't worry. Except, the test report with Jacoco but an alternative solution is proposed further.
This is a Maven project.
Import it in your favorite IDE (for my part IntelliJ). 


How use API ?

To test the api, you can use the following link which will redirect to the Swagger documentation. http://localhost:9000/swagger-ui/#/ 
You will then have a visual of the 2 coded endpoints.
To test them press "Try it out".

![image](https://user-images.githubusercontent.com/32506449/155891973-37fe659b-a6b3-4f8c-935a-69304e7bfb1c.png)

And then fill in the JSON request or the id depending on the endpoint to test.
You will then have the HTTP response and its JSON return.

Important: a H2 database has been chosen for the project. A SQL script is launched when the Spring Boot application is launched.

However the user table is empty so I suggest you to test the api this way:
- Execute the POST endpoint to create a user in the database
- Then you can call the GET endpoint with the id of the user registered.

But this scenario covers a part of the usage. There are business constraints that allow to register a user. User must be French and adult to be registered in database.
It will then be necessary to play with the 2 following fields: 
- countryResidence --> "France" --- The validation is case sensitive "france" or "FRANCE" for example make the user registration fail.
- birthDate --> "2000-02-26"


There are no request samples.
Swagger generates the request body, you just have to modify the values of the interesting fields to be tested in the business constraints.

Report test.

To check the coverage of the API tests.
You can access this link http://localhost:63342/apiUser/target/site/jacoco/index.html which will direct you to an HTML report generated by Jacoco.
Or you can look at the test coverage by package for example on IntelliJ if you run with coverage test classes.