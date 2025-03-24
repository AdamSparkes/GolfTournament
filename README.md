# Golf Tournament REST API

This project demonstrates a simple **golf club membership** and **tournament** system using **Spring Boot**, **JPA/Hibernate**, and **MySQL**. It provides a **REST API** to manage **Members**, **Tournaments**, and the relationship between them.

## Table of Contents

1. [Features](#features)  
2. [Technologies](#technologies)  
3. [Prerequisites](#prerequisites)  
4. [Build & Run Locally](#build--run-locally)  
5. [Docker Setup](#docker-setup)  
6. [API Endpoints](#api-endpoints)  
   - [Members](#members-endpoints)  
   - [Tournaments](#tournaments-endpoints)  
7. [Data Transfer Objects (DTOs)](#data-transfer-objects-dtos)  
8. [Search Functionality](#search-functionality)  
9. [Testing with Postman](#testing-with-postman)  
10. [License](#license) (optional)

---

## 1. Features <a name="features"></a>

- **Object Relational Mapping** using **JPA/Hibernate**  
- **Many-to-many** relationship: a Member can join many Tournaments, and a Tournament can have many Members  
- Basic **CRUD** operations for Members and Tournaments  
- **DTO-based** approach to avoid large or cyclical JSON structures  
- **Search capabilities** (by name, membership type, tournament start date, location)  
- **Dockerfile** for containerizing the application, making it easy to run anywhere

---

## 2. Technologies <a name="technologies"></a>

- **Java 17**  
- **Spring Boot** 3.x (Web, Data JPA)  
- **MySQL** connector for database connectivity  
- **Maven** for build management  
- **Docker** (optional) for containerization

---

## 3. Prerequisites <a name="prerequisites"></a>

- **Java 17** (or adapt if using another version)  
- **Maven** (if building from the command line; IntelliJ can handle Maven projects automatically)  
- **MySQL** (locally installed or accessible via Docker)  
- (Optional) **Docker** if you want to build and run the app in a container

---

## 4. Build & Run Locally <a name="build--run-locally"></a>

1. **Clone** this repository:
   ```bash
   git clone https://github.com/your-username/golf-tournament.git
