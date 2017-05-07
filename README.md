# ms-user-api

### Springboot microservices to manage users ###

This project contains bunch of springboot APIs that allow to get/add users in in-memory H2 databse. The APIs use JPA to connect to database


### Pre-requisites ###
* Java 8 installed
* STS or Intellij to support microservices development
* Latest maven installed

### Build app ###
* Clone repository using `git clone https://github.com/iqbaldeep/ms-user-api.git`
* Navigate to directory `cd ms-user-api`
* Install dependencies using `mvn clean install`
### Run app ###
* The deployable JAR can be located inside target folder
* Deploy the app on a tomcat server using 
	* Windows: `java -jar user-demo-api-0.0.1-SNAPSHOT.jar`
	* Linux: `nohup java -jar user-demo-api-0.0.1-SNAPSHOT.jar &`
