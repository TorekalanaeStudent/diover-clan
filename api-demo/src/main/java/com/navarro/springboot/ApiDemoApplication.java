package com.navarro.springboot;

// Code-Based Analysis
/**
 *  @author Navarro, Vince Justine
 *  @StillLizard0106
 *
 * 1. How did you create your Spring Boot project?
 * A: I created it by using Spring Initializr (start.spring.io) with Gradle and Java 21 using the Spring Web Dependency.
 *
 * 2. What is the purpose of the @RestController annotation?
 * A: It's used to create RESTful web services by combining @Controller and @ResponseBody.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 * A:  It's used in REST controllers to map HTTP GET requests specifically for the path /me
 *
 * 4.Why did you change from returning a String to a Map?
 * A: Because in Task 6, I was required to return structured JSON instead of plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 * A: Spring Boot includes Jackson Library by default, which basically converts Java objects and maps into JSON format.
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}
