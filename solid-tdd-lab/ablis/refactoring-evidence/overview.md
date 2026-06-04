# Solid-TDD Lab

## Project Overview
A refactored Spring Boot application showcasing SOLID principles, OOP best practices, and unit testing with JUnit 5 and Mockito — built on top of an existing GRASP-based design. Now also learned what JaCoCo test is and what it showcases.
This overview  also includes the following:
```already good design that was present```
```before and after```

---

## Architecture

Controller > Service > Repository > Database

---

## Already Good Design

### DTO Layer
`UserRequest` and `UserResponse` DTOs keep API contracts separate from internal entities, preventing direct database exposure.

---

### Mapper Layer
`UserMapper` handles all `DTO ↔ Entity` conversions, keeping transformation logic out of business logic (Adapter pattern, SRP).

---

### Exception Handling
`UserNotFoundException` and `GlobalExceptionHandler` manage missing resources cleanly at the controller level, eliminating null returns.

---

### Layered Architecture
- **Controller** — HTTP requests only
- **Service** — business logic
- **Repository** — database operations

---

### Dependency Injection (DIP)
Constructor injection is used throughout, keeping the service loosely coupled to its repository and mapper abstractions.

---

### Encapsulation
`User` fields are only modified through controlled methods, not exposed directly.

---

### Testable Design
Injected dependencies and isolated business logic make the codebase fully mockable with Mockito.

---

## Before and After Refactoring

### Before

#### 1. Setter-based construction
```java
User user = new User();
user.setUsername(req.username());
user.setEmail(req.email());
user.setPassword(req.password());
```
Problems: mutable at any point, no construction contract, verbose, weak encapsulation.

#### 2. Service-managed entity state
The service directly manipulated entity fields instead of delegating to the domain object.

#### 3. Anemic domain model
`User` was a plain data holder with no behavior of its own.

#### 4. No standardized object creation
Object initialization was repetitive and inconsistent across tests and services.

---

### After

#### 1. Builder pattern
```java
User user = User.builder()
        .id(1L)
        .username("freddy")
        .email("freddyfazbear@mail.com")
        .password("freddy@ururur")
        .build();
```
Cleaner, readable, and consistent object creation with less boilerplate.

#### 2. Encapsulated updates (`updateDetails`)
```java
user.updateDetails(req.username(), req.email(), req.password());
```
State changes now live inside the entity, reducing service-layer responsibility.

#### 3. Richer domain model
`User` now holds behavior (update logic), moving toward true OOP rather than a data-only structure.

#### 4. Cleaner tests
Builder usage simplifies test setup, removes setter dependency, and makes different object states easy to construct.