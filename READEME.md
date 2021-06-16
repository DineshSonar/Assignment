Requirements
Listed below is the requirement of the project to be delivered, required features are expected to
be complete. Candidate who will also implemented optional features will be given more chance.
3.1 Required features
Create a Maven project to implement a simple Spring based web application with a controller
exposing the following 4 APIs
• GET /user
• POST /user
• PUT /user
• DELETE /user
Those APIs will perform CRUD operations using a persistence framework on a User entity with
at minimum the following fields:
• id (long) / primary key
• username (String) / unique
• password
• status / possible values: Activated/Deactivated
Secure those 4 APIs with Spring Security using BASIC authentication.
Provide unit tests for controllers, services and DAO classes.

For building and running the application you need:

JDK 1.8
Maven 3
H2
Postman


Running the application locally
You can execute the main method in the com.uxpsystems.assignment.AssignmentApplication class from your IDE.

or 

extract .zip file and open command prompt inside assignment folder and run following scripts.

1) mvn clean install
2) mvn spring-boot:run 

After it get successfully started you can connect to H2 database
1) Go to browser.
2) Enter this url : http://localhost:9090/h2-console 
3) You will get login form add JDBC URL : jdbc:h2:mem:assignment
  remaining fields should be remain same like Driver Class: org.h2.Driver, User Name: sa, Password: <Blank>
4) Now, click on test connection then click on connect.
5) After connect you can able to see h2 sql browser and database on left side then click on USER_DATA it will automatically create select query.
6) Press run,  you can able to see column of table USER_DATA.

This will do all configuration and it will exposing the following rest APIs

1) GET /user
       Complete URL : http://localhost:9090/assignment/user
       Request type : GET
	   Input media type : application/json
	   Request body : { "id":"1" }
	   Output media type : application/json
	   Description : This request will fetch data by id.
	   
2) POST /user
       Complete URL : http://localhost:9090/assignment/user
       Request type : POST
	   Input media type : application/json
	   Request body : {  "username":"test",
                         "password":"test",
                         "status":"activated" }
	   Output media type : application/json
	   Description : This request will save data in database.
	   
3) PUT /user
       Complete URL : http://localhost:9090/assignment/user
       Request type : PUT
	   Input media type : application/json
	   Request body : {  "id": 1,
	                     "username":"test",
                         "password":"test",
                         "status":"deactivated" }
	   Output media type : application/json
	   Description : This request will update data based on id.

4) DELETE /user
       Complete URL : http://localhost:9090/assignment/user
       Request type : DELETE
	   Input media type : application/json
	   Request body : 
	   Output media type : application/json
	   Description : This request will delete all records from table.
	   
For spring security in postman we need to add basic auth in Authorization with username : admin and password : admin
For any exception details you can see assignment.log file generated inside assignment folder.
For official document you can check doc folder inside assignment folder.



