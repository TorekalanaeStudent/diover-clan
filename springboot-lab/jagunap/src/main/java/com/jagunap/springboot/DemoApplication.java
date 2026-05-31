package com.jagunap.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * STEP 10 - REFLECTION
 *
 * 1. What changed from previous lab?
 *    - Previous lab used hardcoded/in-memory data.
 *    - Now data is persisted in a real database using Spring Data JPA.
 *    - Data survives application restarts.
 *
 * 2. Why is database better?
 *    - Stores data permanently
 *    - Supports multiple users simultaneously
 *    - Allows complex queries
 *    - More reliable than hardcoded data
 *
 * 3. How did JPA help?
 *    - Automatically creates tables from entity classes
 *    - Handles SQL through repository methods
 *    - Maps database rows to Java objects
 *    - No manual SQL needed
 *
 * 4. What changed when switching DB?
 *    - Only application.properties changed!
 *    - Application code stayed exactly the same
 *    - Shows power of abstraction and JPA
 *
 * TWO IMPROVEMENTS:
 *    1. Add input validation using @NotNull, @Email, @Size annotations
 *    2. Add DTO pattern to avoid exposing entity fields directly
 */
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}