# Microservices Lab: API Gateway, JWT Authentication, and Protected Services

## Overview

This school assignment implements a basic microservices architecture with JWT-based authentication and routing through an API Gateway.

The system includes the following components:

- AuthService: Authenticates users and issues JWT tokens.
- API Gateway: Routes requests to services and verifies JWT tokens.
- JokeService: Returns a random programming joke. Protected by JWT.
- QuoteService: Returns a random quote. Protected by JWT.

All services are containerized using Docker and managed with Docker Compose.

## How to Run

1. Make sure you have Docker and Docker Compose installed.
2. Build and start the system using:

## Run All (with Docker Compose)
docker-compose up --build

This will start all four services.

## How to Test (using Insomnia)

1. Open Insomnia and create a **POST** request to:

http://localhost:8080/api/auth/login


- Go to the **Body** tab → select **JSON**
- Enter the login credentials:

  ```json
  {
    "username": "user",
    "password": "password"
  }
  ```

- Click **Send**
- The response will contain a token like:

  ```json
  {
    "token": "eyJhbGciOiJIUzUxMiJ9..."
  }
  ```

2. Create a **GET** request to one of the protected endpoints:

http://localhost:8080/api/jokes/random

or

http://localhost:8080/api/quotes/random


- Go to the **Auth** tab
- Choose **Bearer Token**
- Paste the token from step 1

- Click **Send** to receive a joke or quote.

3. To test unauthorized access:

- Disable or remove the token in the Auth tab
- Send the request again
- You should receive a `401 Unauthorized` response

## Project Structure

Each service is in its own folder with a Dockerfile. The root directory contains the `docker-compose.yml` file that builds and runs all services.

- `authservice/`
- `apigateway/`
- `jokeservice/`
- `quoteservice/`

## Notes

- The JWT secret key is hardcoded and shared between AuthService and API Gateway for simplicity.
- The services are stateless and communicate only through HTTP.
- This project fulfills the requirements for the "Godkänt" level of the lab assignment.
