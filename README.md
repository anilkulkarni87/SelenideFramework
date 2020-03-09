# Selenide Automation
## Scope:
    - Can be updated when leveraging this framework for a project
    - Google search
    - Junit 5 parametrized test
  
## Built With
* [Selenide](https://selenide.org/) - Selenide is a framework for test automation powered by Selenium WebDriver
* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit5](https://junit.org/junit5/) - Test Framework for Java
* [Allure](http://allure.qatools.ru/) - Test Reporting Framework
* [Docker](https://www.docker.com/) - For generating Emailable report.
* [Java Faker](https://github.com/DiUS/java-faker) - For dynamic test data.

    
#### How to Execute
* Step 1: To execute the test.
    * Test Class 1 <br>
``` mvn clean test -Dtest=<Classname1> -Duser=<user> -Dproperty=sample.properties```
    * Test Class 2 <br>
```mvn clean test -Dtest=<Classname2> -Duser=<user> -Dproperty=sample.properties```

* Step 2: To look at Test report.
```
mvn allure:serve
``` 
 #### Allure Report
 ![Image of Allure Report](/allure-report.png?raw=true "Allure Report")
 
 #### What it does now:
Ability to search on Google iteratively be leveraging Junit 5 Parametrized test
 
 #### Emailable Report
 To get emailable version of the report, we need to run the below command. 
 ```
 docker run -p 4040:4040 -p 5050:5050 -e CHECK_RESULTS_EVERY_SECONDS=3 -e KEEP_HISTORY="TRUE" -v "$(pwd)/target/allure-results:/app/allure-results" frankescobar/allure-docker-service
 ```
 Once the docker container is up and running :
 * To view the report navigate to: `http://localhost:5050/emailable-report/render`
 * To export the report navigate to: `http://localhost:5050/emailable-report/export`
 * [Emailable Report Sample](/emailable-report-sample.html)
 
 
 ## Authors
 
 * **Anil Kulkarni** 
 
 #### TODO
    -Use picocli/other libraries for arguments.
    -Exception handling.
    -Better Test Data handling. 
