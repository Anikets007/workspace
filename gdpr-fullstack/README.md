GDPR Spring Boot Example

This is a minimal Spring Boot project scaffold for the GDPR customer data management system.
It includes:
- Basic Customer entity, repository, service and REST controller
- Simple JWT-based authentication endpoint (/auth/login) that returns a token for demo credentials
- Security config with a JwtFilter that protects /api/** endpoints

How to run:
1. Install Java 8 and Maven.
2. Build: mvn clean package
3. Run: java -jar target/gdpr-0.0.1-SNAPSHOT.jar

Demo credentials:
- username: admin
- password: password

Application properties are in src/main/resources/application.properties
