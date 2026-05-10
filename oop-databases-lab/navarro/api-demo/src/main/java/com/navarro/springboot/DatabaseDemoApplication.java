package com.navarro.springboot;
// Reflection
/**
 *  @author Navarro, Vince Justine
 *  @StillLizard0106
 *
 * 1. What changed from previous lab?
 * A: This lab replaced that with a real database persistence using User and Product entities,
 *    repositories, services, and CRUD endpoints.
 *
 * 2. Why database is better?
 * A: You can easily store, update, and delete records easily without touching the source code
 *    and multiple users can read/write data at the same time.
 *
 * 3. How JPA helped?
 * A: Switching databases required zero changes to your Java code and makes complex SQL
 *    into simple Java interfaces,
 *
 * 4.WWhat changed when switching DB?
 * A: Only application.properties is changed. To change it just comment out the H2 line
 *    and uncomment PostgreSQL lines.
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

}