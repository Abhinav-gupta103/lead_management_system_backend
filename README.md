# Lead Management System

This is a demo project for a Lead Management System built using Spring Boot. The project includes features for managing restaurant leads, points of contact, interactions, and performance metrics. It also includes JWT-based authentication and authorization.

### Project Structure

    .env
    .gitattributes
    .gitignore
    .mvn/
        wrapper/
            maven-wrapper.properties
    .vscode/
        launch.json
        settings.json
    docker-compose.yaml
    HELP.md
    mvnw
    mvnw.cmd
    pom.xml
    src/
        main/
            java/
                com/
                    lead_management_system/
                        Config/
                        controller/
                        entities/
                        filter/
                        repository/
                        Service/
                            impl/
                        LeadManagementSystemApplication.java
                        GreetingsController.java
            resources/
                application.properties
                static/
                templates/
        test/
            java/
                com/
                    lead_management_system/
                        lead_management_system/
                            LeadManagementSystemApplicationTests.java
    target/

### Prerequisites

- Java 17
- Maven
- Docker (for running PostgreSQL and pgAdmin)

## Getting Started

Clone the Repository

```
git clone https://github.com/Abhinav-gupta103/lead_management_system_backend.git
cd lead-management-system
```

### Set Up Environment Variables

Create a .env file in the root directory with the following content:

```
POSTGRES_DB_USERNAME=your_db_username
POSTGRES_DB_PASSWORD=your_db_password
```

### Run PostgreSQL and pgAdmin Using Docker

```
docker-compose up -d
```

### Build and Run the Application

```
./mvnw clean install
./mvnw spring-boot:run
```

## Access the Application

- The application will be running at http://localhost:8080
- pgAdmin will be accessible at http://localhost:5050

### API Endpoints

#### Authentication

- POST /api/signin: Authenticate a user and get a JWT token.

#### Restaurant Leads

- POST /api/leads: Add a new lead.
- PUT /api/leads/{id}: Update an existing lead.
- GET /api/leads: Get all leads.
- GET /api/leads/{id}: Get a lead by ID.
- DELETE /api/leads/{id}: Delete a lead.
- GET /api/leads/status/{status}: Get leads by status.

#### Points of Contact

- POST /api/contacts/{restaurantId}: Add a new point of contact for a restaurant.
- PUT /api/contacts/{id}: Update an existing point of contact.
- GET /api/contacts: Get all points of contact.
- GET /api/contacts/restaurant/{restaurantId}: Get points of contact by restaurant ID.
- GET /api/contacts/{id}: Get a point of contact by ID.
- DELETE /api/contacts/{id}: Delete a point of contact.

#### Interactions

- POST /api/interactions/{restaurantId}: Add a new interaction for a restaurant.
- PUT /api/interactions/{id}: Update an existing interaction.
- GET /api/interactions: Get all interactions.
- GET /api/interactions/restaurant/{restaurantId}: Get interactions by restaurant ID.
- GET /api/interactions/{id}: Get an interaction by ID.
- DELETE /api/interactions/{id}: Delete an interaction.
  Performance
  GET /api/performance: Get performance data for all restaurants.
  GET /api/performance/{restaurantId}: Get performance data for a specific restaurant.

## Security

The application uses JWT for authentication and authorization. The security configuration can be found in SecurityConfig.

## License

This project is licensed under the Apache License 2.0. See the LICENSE file for details.
