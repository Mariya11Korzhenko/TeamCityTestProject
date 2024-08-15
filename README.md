# TeamCityTestProject

## Overview
TeamCityTestProject is a Maven-based Java project that includes a suite of automated tests for TeamCity. It leverages several libraries and tools such as Selenide for browser automation, Rest-Assured for API testing, and Allure for reporting. This project is configured to run tests using TestNG and generate detailed reports with Allure.

## Teamcity Project Setup using the Teamcity server
You can use the TeamCity server offered through the following link: https://www.jetbrains.com/teamcity/signup/.
Use Gitlab/Githab/Bitbucket/Google account for the remote server with DB creation. 

## Teamcity Project Setup using the Docker
To set up a TeamCity server using Docker, you can follow these steps.
The TeamCity server Docker image is available on Docker Hub, which makes it easy to get started.

## Install Docker
If you haven't already installed Docker, download and install it from the official Docker website https://www.docker.com/ .

## Pull the TeamCity Server Docker Image
You can pull the latest TeamCity server image from Docker Hub. As of now, you can use the `jetbrains/teamcity-server` image.

```
docker pull jetbrains/teamcity-server
```

## Run the TeamCity Server Container
Now, you can start the TeamCity server using the following command. This command will run the TeamCity server in a Docker container and map the necessary ports:
```
docker run -it --name teamcity-server -v teamcity_data:/data/teamcity_server/datadir -v teamcity_logs:/opt/teamcity/logs -p 8111:8111 jetbrains/teamcity-server
```

* -it: Runs the container interactively.
* --name teamcity-server: Names the container teamcity-server.
* -v teamcity_data:/data/teamcity_server/datadir: Mounts the teamcity_data volume to the TeamCity data directory.
* -v teamcity_logs:/opt/teamcity/logs: Mounts the teamcity_logs volume to the TeamCity logs directory.
* -p 8111:8111: Maps port 8111 on your host machine to port 8111 in the container (TeamCity’s default web interface port).

## Access the TeamCity Web UI

Once the container is running, you can access the TeamCity web interface by navigating to `http://localhost:8111` in your web browser.


## Automation Project Setup
### Prerequisites
Ensure you have the following installed on your system:
* Java 17 or later
* Maven 3.8.1 or later

### Getting Started
Clone the Repository:
```
git clone https://github.com/your-repository/TeamCityTestProject.git
cd TeamCityTestProject
```

### Build the Project:
Navigate to the project directory and use Maven to build the project:
```
mvn clean install
```
### Run Tests:
To execute the tests, run the following command:
```
mvn test
```
### Generate Allure Reports:
After running the tests, you can generate Allure reports using:
```
mvn allure:report
```
To view the report, use:
```
mvn allure:serve
```

### Dependencies
The project relies on the following key dependencies:

* Selenide: For browser automation.
* Rest-Assured: For API testing.
* AspectJ: For aspect-oriented programming.
* Owner: For configuration management.
* Jackson: For JSON processing.
* Lombok: For reducing boilerplate code.
* TestNG: For running tests.
* AssertJ: For fluent assertions.
* JetBrains Annotations: For additional annotations.
* Allure: For test reporting.

