package com.go.springboot.exception;

/*  Reflection
 *
 *  @author Go, Sean Ethan
 *  @sethplaysbadly
 *
 * 1. What changed from previous lab?
 * A: This lab replaced the prior lab with an actual database persistence with additional User/Product entities,
 *    repositories, services, and CRUD endpoints.
 *
 * 2. Why database is better?
 * A: You have the ability to easily store, update, and delete records without tampering with the source code,
 *    multiple users can read/write data at the same time; like an actual app with a server backend.
 *
 * 3. How JPA helped?
 * A: Switching databases required zero changes to your Java code and aides complex SQL
 *    into simple Java interfaces,
 *
 * 4. What changed when switching DB?
 * A: Only application.properties changed. To change it just comment out the H2 line
 *    and uncomment PostgreSQL lines.
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) { super(message); }
}