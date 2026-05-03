package com.ovejera.springboot;

/*
How did you create your Spring Boot project?
-> Created via Spring Initializr (start.spring.io) with Maven build tool, Java 21, Spring Boot 3.2.0. Added spring-boot-starter-web and spring-boot-starter-test dependencies. Includes Maven wrapper (mvnw) for consistent local builds.

What is the purpose of the @RestController annotation?
-> Combines @Controller and @ResponseBody. Marks the class as a REST endpoint handler, automatically serializes method return values directly to HTTP response bodies without view resolution.

What does the @GetMapping("/me") annotation do?
-> Maps all HTTP GET requests to the /me URL path to the annotated method (getMe()), routing those requests to be handled by that method.

Why did you change from returning a String to a Map?
-> A String only returns a single text value. A Map allows returning structured data with multiple key-value pairs (name, studentId, course, message) to convey richer information in the API response.

How does Spring Boot handle JSON responses automatically?
-> Spring Boot includes Jackson (via the spring-boot-starter-web dependency) which automatically serializes returned objects (Map, POJO) into JSON format and sets the Content-Type header to application/json.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}
