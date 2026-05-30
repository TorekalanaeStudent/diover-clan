# Solid-TDD Lab

## Project Overview
This project is a refactored Spring Boot application demonstrating SOLID principles, OOP best practices, and unit testing using JUnit 5 and Mockito. It is an improved version of a GRASP-based design, focusing on maintainability, testability, and clean architecture.
This readme also includes the following:
```already good design that was present```
```before and after```
---

## Architecture

The system follows a layered architecture:

Controller > Service > Repository > Database

---

## The already good design that was present in my code are:

### DTO layer for request/response separation
- The system already uses 'UserRequest' and 'UserResponse' DTOs to separate internal entity structure from API contracts.
- This prevents exposing the database to directly to the client which in turn improves security

---

### Mapper layer for object transformation
A dedicated 'UserMapper' was already implemented to handle conversion between:
``` DTO > Entity ```
``` Entity > DTO ```
This follows the Adapter pattern and keeps transformation logic separate from business logic, supporting Single Responsibility Principle
### Exception handling for business rules
- Custon exception handling `userNotFoundException` was already implemented to handle missing resources properly.
- This improves clarity of error handling and avoids returning null values

---

### Layered Architecture
This project already follows a clean layered structure:
	+ Controller: Handles HTTP requests onmly
	+ Service: Contains business logic
	+ Repository: Handles database operation
This separation improves the maintainability of the system
### Dependency Injection Principle (DIP
The system already uses constructor injection with Spring-managed beans:
- Service depends on repository abstraction
- Service depends on mapper abstraction
This reduces tight coupling and supports unit testing with mocks

---

### Encapsulation in Entity Design
The `User` entity encapsulates its data fields and is only modfied through controlled methods (initially setters, later improved with update methods and builder pattern)

---

### Testable Architecture
The design already supports unit testing using Mockito becuse:
- Dependencies are injected
- Components are loosely copupled
- Business logic is isolated in the service layer

---

## This section includes the Before and After Refactoring

### Before Refactoring
The original implementation had a more traditional but less expressive OOP design:

#### 1. Setter-based bject construction and mutation
Entities were created and modified using setters:
```java
User user = new User();
user.setUsername(req.username());
user.setEmail(req.email());
user.setPassword(req.password());
```

Problems:
- Object state could be modified at any time
- No clear construction contract
- More verbose and error-prone code
- Weak encapsulation of object creation

---

#### 2. Business logic spread between service and entity
The service layer directly controlled entity state changes instead of delegating behavior to the domain
This made the service more resonsible for internal object state management.

---

#### 3. Less expressive domain model
The `User` entity was treated as a simple data container often called an anemic model, rather than an object with behavior.

---

#### 4. Object creation was not standardized
There was no consistent pattern for creating obvjects, leading to repetitive and manual initialization logic in tests and services.

---

### After Refactoring
The system was imrpoved using OOP best practices and design patterns.

#### 1. Builder pattern introduced for object creation
The `User` entity now uses Lombok Builder:
```java
User user = User.builder()
        .id(1L)
        .username("sigma")
        .email("sigma@mail.com")
        .password("pass")
        .build();
```
Benefits:
- Standardized and readable object creation
- Reduced boilerplate code
- Improved immutabiity-style construction
- Cleaner test setup

---

#### 2. Encapsulated update behavior (updateDetails)
Instead of modifying fields directly in the service, updates are now handled inside the entity:
```java
user.updateDetails(req.username(), req.email(), req.password());
```

Benefits:
- Better encapsulation of state changes
- Moves behavior closer to the domain model
- Reduces service-layer responsibility
- Improves maintainability

---

#### 3. Improved domain modeling
The entity now contains behavior (update logic), not just data.

This shifts the design closer to object-oriented principles rather than a pure data structure approach.

#### 4. Improved test structure and readability

Because of Builder usage:

- Test data setup is cleaner
- Less reliance on setters
- Easier to construct different object states