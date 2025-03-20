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

## Project Setup

### Prerequisites

- JDK 11 or higher
- Maven
- MongoDB Atlas account

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/zylentrix_assessment.git
   cd zylentrix_assessment
   ```

2. Update the MongoDB connection string in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/<database-name>
   spring.data.mongodb.database=<database-name>
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
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

This project uses MongoDB Atlas as the database. MongoDB Atlas is a fully-managed cloud database service that handles all the complexity of deploying, managing, and healing deployments on the cloud service provider of your choice.

### User Schema

The user entity is defined with the following fields:
- `id`: String (auto-generated)
- Other fields defined in the `UserInDB` class
- DTO pattern implemented with `UserDto` for data transfer

## How to Use

### Example Request - Create New User

```bash
curl -X POST \
  http://localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "John Doe",
    "email": "john.doe@example.com",
    "password": "securepassword"
  }'
```

### Example Request - Get User by ID

```bash
curl -X GET http://localhost:8080/users/{id}
```
