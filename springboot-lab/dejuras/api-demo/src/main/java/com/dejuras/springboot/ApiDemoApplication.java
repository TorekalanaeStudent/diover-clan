package com.dejuras.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Code-Based Analysis
/**
 *  @author De Juras, Clint Norbert P.
 *  @cdejuras- edit test
 *
 * 1. How did you create your Spring Boot project?
 * A: I created it by using Spring Initializr (start.spring.io) with Gradle and Java 26 using the Spring Web Dependency.
 *
 * 2. What is the purpose of the @RestController annotation?
 * A: It combines @Controller and @ResponseBody, marking the class as a REST controller where every method automatically returns data (like JSON) directly in the response body instead of a view.
 *
 * 3. What does the @GetMapping("/me") annotation do?
 * A: It maps HTTP GET requests to the /me endpoint specifically, meaning only GET requests to that path will trigger the method. Other HTTP methods like POST or PUT will not be handled by it.
 *
 * 4. Why did you change from returning a String to a Map?
 * A: Because in Task 6, I was required to return structured JSON instead of plain text.
 *
 * 5. How does Spring Boot handle JSON responses automatically?
 * A: Spring Boot includes the Jackson library by default, which automatically serializes Java objects and Maps into JSON format when a method in a @RestController returns an object.
 *
 */
@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}
