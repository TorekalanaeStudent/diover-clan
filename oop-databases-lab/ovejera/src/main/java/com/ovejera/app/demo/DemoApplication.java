package com.ovejera.app.demo;

/*
What changed from previous lab?
-> Previous lab (springboot-api) returned hardcoded data from a simple controller (MeController). This lab adds: JPA/Hibernate for ORM, Entity classes (User, Product) with @Entity, Repository layer (JpaRepository), Service layer, full CRUD operations (GET/POST/PUT/DELETE), validation (spring-boot-starter-validation), Lombok for boilerplate reduction, and PostgreSQL database integration with H2 as an option.

Why database is better?
-> Hardcoded data is lost on restart and cannot scale. A database provides persistence (data survives restarts), data integrity via constraints, support for complex queries/filtering, proper concurrency handling for multiple users, scalability for large datasets, and real-world applicability for production applications.

How JPA helped?
-> JpaRepository provides built-in CRUD methods (save, find, delete) without writing SQL. Entities are auto-mapped to database tables. Database switching requires minimal code changes—JPA handles the ORM via Hibernate. Pagination and sorting are built-in. The Repository interface (e.g., UserRepository extends JpaRepository<User, Long>) needs no implementation.

What changed when switching DB?
-> In application.properties: datasource URL changed from H2 in-memory (jdbc:h2:mem:testdb) to PostgreSQL (jdbc:postgresql://localhost:5432/ovejeraDB), driver class changed to org.postgresql.Driver, credentials updated, and Hibernate dialect changed to PostgreSQLDialect. The Java code (entities, repositories, services, controllers) remained unchanged—JPA abstracts the database layer.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
