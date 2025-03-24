# Golf Tournament REST API

This project demonstrates a simple golf club membership and tournament system using Spring Boot, JPA/Hibernate, and MySQL. It provides a REST API to manage Members, Tournaments, and the relationship between them.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Build & Run Locally](#build--run-locally)
- [Docker Setup](#docker-setup)
- [API Endpoints](#api-endpoints)
- [Data Transfer Objects (DTOs)](#data-transfer-objects-dtos)
- [Search Functionality](#search-functionality)
- [Testing with Postman](#testing-with-postman)
- [License](#license)

## 1. Features

- Object Relational Mapping using JPA/Hibernate
- Many-to-many relationship: a Member can join many Tournaments, and a Tournament can have many Members
- Basic CRUD operations for Members and Tournaments
- DTO-based approach to avoid infinite JSON recursion
- Search capabilities (by name, membership type, tournament start date, etc.)
- Dockerfile for containerizing the application, so another developer can easily run it

## 2. Technologies

- Java 17
- Spring Boot 3.x (web, data JPA)
- MySQL connector for database access
- Maven for build management
- Docker (optional) for containerization

## 3. Prerequisites

- Java 17 (or adjust if you're using another version)
- Maven (if building locally without IntelliJ's built-in Maven)
- MySQL running (local or Dockerized), or adapt to another database in `application.yml`
- (Optional) Docker if you want to build and run in a container

## 4. Build & Run Locally

1. Clone this repository:
```bash
git clone https://github.com/your-username/golf-tournament.git
```

2. Navigate to the project folder:
```bash
cd golf-tournament
```

3. Configure MySQL credentials in `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/golf_club_db
    username: root
    password: password123
  jpa:
    hibernate:
      ddl-auto: update
```
(Adjust as needed for your MySQL server)

4. Build the project:
```bash
mvn clean package
```

5. Run the JAR:
```bash
java -jar target/golf-tournament-0.0.1-SNAPSHOT.jar
```

The app should start on `http://localhost:8080`.

## 5. Docker Setup

There is a Dockerfile in the root of the project. To build and run:

1. Build the jar:
```bash
mvn clean package
```

2. Build the Docker image:
```bash
docker build -t golf-tournament .
```

3. Run the container:
```bash
docker run -p 8080:8080 golf-tournament
```

If you also need MySQL via Docker, either update your `application.yml` to point to the container or use a `docker-compose.yml` with both MySQL and app services.

## 6. API Endpoints

Your REST endpoints are accessible under `http://localhost:8080/api/...`. These endpoints serialize and deserialize data using DTO classes to avoid large or cyclical JSON.

### A. Members Endpoints

- `GET /api/members`
  - Returns a list of all MemberDTO

- `GET /api/members/{id}`
  - Returns a single MemberDTO by id

- `POST /api/members`
  - Creates a new Member from a MemberDTO JSON body

  Example body:
  ```json
  {
    "name": "Alice Johnson",
    "address": "123 Golf Lane",
    "email": "alice@example.com",
    "phoneNumber": "555-1234",
    "startDate": "2023-01-01",
    "duration": 12,
    "membershipType": "Gold",
    "tournamentIds": []
  }
  ```

- `DELETE /api/members/{id}`
  - Deletes a member by id

(Optional) You could add a PUT endpoint to update an existing member.

### B. Tournaments Endpoints

- `GET /api/tournaments`
  - Returns a list of TournamentDTO

- `GET /api/tournaments/{id}`
  - Returns a single TournamentDTO

- `POST /api/tournaments`
  - Creates a new Tournament

  Example body:
  ```json
  {
    "startDate": "2023-06-01",
    "endDate": "2023-06-03",
    "location": "Pebble Beach",
    "entryFee": 200.00,
    "cashPrize": 5000.00,
    "memberIds": []
  }
  ```

- `DELETE /api/tournaments/{id}`
  - Deletes a tournament by id

(Optional) A PUT endpoint for updating the tournament is also possible.

## 7. Data Transfer Objects (DTOs)

- MemberDTO and TournamentDTO define exactly what fields appear in your JSON
- Each includes a list of IDs (tournamentIds or memberIds) to prevent infinite recursion
- Entities (Member, Tournament) remain purely for database interactions
- Mappers (e.g. MemberMapper, TournamentMapper) convert between Entity ↔ DTO

## 8. Search Functionality

MemberRepository includes methods like:
- `findByName(String name)`
- `findByMembershipType(String membershipType)`
- `findByPhoneNumber(String phoneNumber)`
- `findByStartDate(LocalDate startDate)`

TournamentRepository includes:
- `findByStartDate(LocalDate startDate)`
- `findByLocation(String location)`

You can expose these searches as additional controller endpoints or pass them as query params—for example:
- `GET /api/members/search?name=Alice`
- `GET /api/tournaments/search?location=Augusta`

(Implementation not shown here, but you have the repository methods ready.)

## 9. Testing with Postman

1. Install Postman (if not already)
2. Create a new request:
   - Method: POST
   - URL: `http://localhost:8080/api/members`
   - Body → "raw" → "JSON", with sample JSON:
     ```json
     {
       "name": "Bob Smith",
       "address": "456 Fairway Blvd",
       "email": "bob@example.com",
       "phoneNumber": "555-5678",
       "startDate": "2023-03-15",
       "duration": 6,
       "membershipType": "Silver",
       "tournamentIds": [1, 2]
     }
     ```
3. Click Send and check the response
4. Repeat for GET, DELETE, and Tournament endpoints

Screenshots: Include screenshots of successful requests/responses for submission.

## 10. License

This project is for educational/demo purposes. You may add your license of choice, e.g. MIT, Apache 2.0.
