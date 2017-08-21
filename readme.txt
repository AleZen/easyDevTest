--------------
For more documentation visit http://easydev.org/#/documentation/template/java
--------------

--------------
PREREQUISITES
--------------

    - maven
    - jdk 1.7
    - Orcale Database


--------------
CONFIGURE DATABASE
--------------

Install in you maven repository the jar com.oracle.ojdbc14 version 10.2.0.2.0 you can download this jar registering at Oracle website from 
    http://www.oracle.com/technetwork/apps-tech/jdbc-10201-088211.html

On database execute the SQL script script/schemaDb_[NAME_DB].sql generated in your project folder.

Insert IP, user and pass of database on your properties file in src/main/webapp/WEB-INF/application.properties

--------------
START APPLICATION
--------------

For start the application open a command line in the project's folder an type:

    mvn jetty:run

This will start a lite java server on your pc and run the application.

Go to http://localhost:8080/[NAME_PROJECT]

--------------
CONFIGURE
--------------

For JAVA and database config edit
    src/main/webapp/WEB-INF/application.properties

For AngularJS edit
    src/main/webapp/properties.js

