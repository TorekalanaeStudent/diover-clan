package com.go.springboot.entity;
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
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User { // no way you actually forgot the endpoint of this bro T~T
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private boolean isRegular;
    private String role;

    // Getters & Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public boolean isRegular() { return isRegular; }
    public String getRole() { return role; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String p) { this.phoneNumber = p; }
    public void setEmail(String email) { this.email = email; }
    public void setRegular(boolean r) { this.isRegular = r; }
    public void setRole(String role) { this.role = role; }

}