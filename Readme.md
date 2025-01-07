# Hospital Management Application

This project is a Spring Boot application connected to a MySQL database, designed for managing hospital-related data. The application is containerized using Docker and can be deployed seamlessly.
## Features
* Spring Boot backend for managing hospital data.
* MySQL database integration.
* Fully containerized using Docker.
* Networked containers for application and database communication.


## Prerequisites

Before you start, ensure you have the following installed:

* Docker: Install Docker
* Docker Hub Account (optional, for pushing images)

## Setup Instructions

## 1st way 
### Step 1: Create a Docker Network

Create a dedicated Docker network for the application and database to communicate.

```bash
docker network create hospital-network
```

### Step 2: Run the MySQL Container

Start a MySQL container with the required environment variables.

```bash
docker run -d --name mysql-container --network hospital-network -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=hospitaldb -p 3307:3306 mysql:8.0
```
The mysql will accessible at: 3307 port


* **MYSQL_ROOT_PASSWORD:** Sets the root password to `1234`.
* **MYSQL_DATABASE:** Creates a database named `hospitaldb`.

### Step 3: Build and Push the Spring Boot Application Image
1. Build the Docker image for the Spring Boot application:
```bash
docker build -t hospital-app .
```
2. Push the image to Docker Hub (optional):
```bash
docker build -t <docker-hub-username>/hospital-app .
```
### Step 4: Run the Spring Boot Application Container
Start the application container, linking it to the MySQL container.

```bash
docker run -d --name hospital-container --network hospital-network -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/hospitaldb -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=1234 -p 8080:8080 hospital-app
```
* *SPRING_DATASOURCE_URL:* JDBC URL for the MySQL database.
* *SPRING_DATASOURCE_USERNAME:* Database username (`root`).
* *SPRING_DATASOURCE_PASSWORD:* Database password (`1234`).

### Step 5: Access the Application

The application will be accessible at: http://localhost:8080

## 2nd way use docker-compose file
```bash
docker compose -f docker-compose-hospital.yaml up
```

## Verify the Setup
* Check the Running Containers:
```bash
docker ps
```

## Built With

* *Java 17*
* *Spring Boot*
* *MySQL 8.0*
* *Docker*


Feel free to contribute, report issues, or suggest improvements. 😊
