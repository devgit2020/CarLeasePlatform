##<u>Car-Lease Api</u>

This is the car lease application which maintain all the car which is ready for lease and employee or broker will login and create profile for the customer and generate a lease rate for the customer.

## <u>Getting Started</u>

This application has designed based on the DDD design principles. [About DDD](https://en.wikipedia.org/wiki/Domain-driven_design)

This application has 4 sub-domain as below and each sub-domain has individual api for model realization.

1. User  - This endpoint related to User create,authenicate for the application.
2. Customer - This endpoint use for customer create,update,delete for the application.
3. Car - This endpoint use for add new Car to application for lease.
4. Lease - This endpoint use for ask a lease rate for the customer.


## <u>Prerequisites</u>
To run the application on the desktop or laptop, need to have JRE version 11 and above.

## <u>Installing</u>
Below are the steps download the application to your local desktop.


Enter the  [Clone URL](https://github.com/devgit2020/CarLeasePlatform.git) in the browser and then clone or download the application. 

Import the application as maven Project on your local IDE (Eclipse, IntelliJ) etc.

Note: - The IDE should support Java 11 and above complier.

Run the maven install in the project workspace.

It will compile all the java classes, run all the test classes and

This is Springboot applicaiton run in tomcat in-built server with port - 9191.


To execute the test classes related to the application, run below command in the CMD from the root project directory of workspace.
Ex: - if my workspace is in...\test directory, then I will run the command as...\test> mvn test

Test classes can execute through the IDE as well, like maven test.

Execute the main class in the application.

To test applicaiton endpoint, use the postman script here.[script](https://github.com/devgit2020/script.git)

## <u>Built With technology stack</u>

The application has been developed using DDD based approach. DDD helps to create better modularized, extensible and flexible code.

This is springboot based application and developed using java 17.

This application is based on JWT authenecation implementation from spring boot java security functionality.

This application use H2 in-memory DB.

## <u>How to test the endpoint</u>

1. Download the postman script from here. [script](https://github.com/devgit2020/script.git)
2. Import the script from the download location.
3. Run the endpoint first <b><u>Create</u></b> from <b>login</b> folder in postman. The endpoint create a login user for the application. if the call successfully then see response as JWT token.
4. Copy that token and pass to other endpoint as environment before call<b>"Authorization"</b> as <b>"Bearer Token"</b>.It is mandatory to call all endpoint with a valid JWT token.



## Versioning
The first release version is 0.0.1.
