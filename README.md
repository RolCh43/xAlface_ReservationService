# xAlface_ReservationService Microservice
In this college assignment, I was required to extract and refactor a portion of a monolithic classroom reservation system into a dedicated microservice. This microservice handles all classroom reservation logic and operates independently while integrating into a service-oriented architecture. 
<br>

## 🛠️ Technologies Used
-Java

-Spring Boot

-Spring Data JPA

-Eureka (Spring Cloud Netflix)

-H2 / HSQLDB (in-memory database)

-Lombok

-Maven
<br>

## 📌 Features
Create, update, list and delete classroom reservations.

Validates availability and prevents scheduling conflicts.

Communicates with other microservices (e.g., Classroom, User) via REST or Eureka discovery.

Registered with Eureka Discovery Server for dynamic service registration.

Supports local and development profiles.
<br>

## 🔧 How to Run
### Prerequisites:
-JDK 17+

-Maven

-Eureka Discovery Server running

### Run locally:
-bash

-Copy

-Edit

## Clone the repository
git clone https://github.com/your-user/xAlface_ReservationService.git
cd xAlface_ReservationService

## Build the project
mvn clean install

## Run the microservice
mvn spring-boot:run
ℹ️ Make sure the Eureka Discovery Server is already running before starting this service.

<br>
##📂 Project Structure
bash
Copy
Edit
xAlface_ReservationService/
├── src/

│   └── main/

│       ├── java/

│       │   └── application/           # Main package

│       │       ├── controller/        # REST Controllers

│       │       ├── service/           # Business logic

│       │       ├── repository/        # JPA Repositories

│       │       ├── model/             # Entities and DTOs

│       │       └── ReservationServiceApplication.java

│       └── resources/

│           ├── application.yml        # Configuration

│           └── ...

└── pom.xml
<br>

##🔗 Integration
This service is part of a microservice-based system composed of:

-User Service

-Auth Service

-Classroom Service

-Reservation Service (this)

-API Gateway

-Service Discovery (Eureka)

<br>

## 📦 Deployment
This microservice can be containerized using Docker and orchestrated with tools like Docker Compose or Kubernetes.

Example Dockerfile:

dockerfile

Copy

Edit

FROM eclipse-temurin:17-jdk-alpine

COPY target/xAlface_ReservationService.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

Build and run with Docker:

bash

Copy

Edit

docker build -t xalface/reservation-service .

docker run -p 8082:8082 xalface/reservation-service
<br>
## 🧪 Testing
You can test endpoints using Postman or Swagger UI (if integrated). Typical endpoints:

-GET /reservations

-POST /reservations

-DELETE /reservations/{id}

<br>
📚 Academic Context
This project was developed as part of the Software Architecture course at UCSAL, during the 2025.1 semester. The goal was to refactor an existing monolith into a maintainable microservices architecture.

<br>
