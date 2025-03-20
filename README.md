# Zylentrix Assessment - User Management API

This project is a RESTful API for user management built with Spring Boot and MongoDB Atlas. It provides endpoints for creating, reading, updating, and deleting user information.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Project Setup](#project-setup)
- [API Endpoints](#api-endpoints)
- [Exception Handling](#exception-handling)
- [Database Configuration](#database-configuration)

## Features

- Create new users
- Retrieve a list of all users
- Retrieve a specific user by ID
- Update existing user information
- Delete users
- Custom exception handling

## Technologies

- Java 
- Spring Boot
- Spring Web (REST API)
- Spring Data MongoDB
- MongoDB Atlas (Cloud Database)
- Maven
- Lombok

## Project Setup

### Prerequisites

- JDK 11 or higher
- Maven (for development only)

### Running the Application

The application is ready to run with MongoDB Atlas credentials already configured in the application properties.

1. You can directly run the pre-built JAR file available in the target directory:
   ```bash
   java -jar target/zylentrix_assessment.jar
   ```

2. Alternatively, if you want to build from source:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

| Method | URL | Description | Status Codes |
|--------|-----|-------------|--------------|
| GET | `/users` | Get all users | 200 (OK) |
| GET | `/users/{id}` | Get user by ID | 200 (OK), 404 (Not Found) |
| POST | `/users` | Create a new user | 201 (Created), 400 (Bad Request) |
| PUT | `/users/{id}` | Update an existing user | 201 (Created), 400 (Bad Request) |
| DELETE | `/users/{id}` | Delete a user | 204 (No Content), 400 (Bad Request) |

## Exception Handling

The API includes custom exception handling for specific scenarios:

- `UserNotFoundException`: Thrown when a requested user ID does not exist
- `UserCreationException`: Thrown when a user cannot be created due to validation issues or database constraints

## Database Configuration

This project uses MongoDB Atlas as the database with credentials already configured in the application. There's no need to modify any database settings to run the application.

### User Schema

The user entity (`UserInDB`) is defined with the following fields:
- `id`: String (auto-generated MongoDB ID)
- `name`: String (user's full name)
- `email`: String (user's email address)
- `age`: int (user's age)

The entity uses Lombok annotations (`@Getter`, `@Setter`, `@AllArgsConstructor`, `@NoArgsConstructor`) to reduce boilerplate code and is mapped to MongoDB using the `@Document` annotation.

## Data Transfer Object

The application uses a DTO pattern with `UserDto` for transferring user data between the client and the server, separating the internal data representation from the API contract.

## How to Use

### Example Request - Create New User

```bash
curl -X POST \
  http://localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "age": 30
  }'
```

### Example Request - Get User by ID

```bash
curl -X GET http://localhost:8080/users/{id}
```

### Example Request - Update User

```bash
curl -X PUT \
  http://localhost:8080/users/{id} \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "John Doe Updated",
    "email": "john.updated@example.com",
    "age": 31
  }'
```

### Example Request - Delete User

```bash
curl -X DELETE http://localhost:8080/users/{id}
```
