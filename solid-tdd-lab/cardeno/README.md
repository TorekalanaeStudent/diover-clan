# Cardeño SOLID + OOP Unit Testing Lab

**Submitted by:** @flcardeno (Cardeño, Faye L.)

This project builds upon the previous GRASP laboratory activity. The application was refactored to improve maintainability, testability, and code quality by applying SOLID principles and implementing comprehensive unit testing using JUnit 5 and JaCoCo.

---

## Overview

The goal of this refactoring was to improve the overall design of the application by reducing code complexity, strengthening object-oriented principles, and increasing test coverage.

---

## What I Changed

### I. Applied Single Responsibility Principle (SRP)

I noticed that `TaskService` was responsible for both business logic and validation. To improve separation of concerns, I moved the validation logic into a separate `TaskValidator` class.

### II. Applied Dependency Inversion Principle (DIP)

I reduced the direct dependency between the service layer and validation logic.

**Before:** The service depended directly on validation implementation.

**After:** `TaskValidator` is injected into `TaskService`, allowing the service to use validation without being tightly coupled to its implementation.

### III. Improved Error Handling

I created a `GlobalExceptionHandler` to centralize exception handling.

**Benefits:**

* Cleaner controller code
* Easier maintenance

### IV. Improved Data Protection

I introduced `TaskResponse` DTOs instead of exposing entity objects directly through the API.

**Benefits:**

* Protects internal database structure
* Improves security
* Provides controlled API responses

### V. Improved State Integrity

I removed unnecessary `@Setter` annotations from entity classes to promote immutability and prevent unintended modifications to domain objects.

---

## Testing

```bash
mvn clean verify
```

---

### Results

```text
Tests run: 20
Failures: 0
Errors: 0
Skipped: 0
```

**Status:** BUILD SUCCESS

---

## Evidence

See the `refactoring-evidence/` folder for the following files:

* `before-after.pdf`
* `recording_evidence.md`
* `refactoring_evidence.md`
* `Screenshot 2026-05-31 143005.png` (BUILD SUCCESS)
* `Screenshot 2026-05-31 143115.png` (JaCoCo Coverage Report)

---

## Review and Retrospect

### Which principle improved your design the most?

The **Single Responsibility Principle (SRP)** improved the design the most. It made my code easier to understand, maintain, and test.

### What bad design did you remove?

I removed validation logic that was tightly coupled to the service layer and eliminated repetitive error-handling code from the controller layer.

### Which principle was the hardest to apply?

The **Dependency Inversion Principle (DIP)** was the most challenging because it required changing from direct object creation to dependency injection.

---

### Reflection

This activity taught me that code coverage is not just a metric to achieve. It helps identify untested paths and edge cases in the application. Writing tests for invalid inputs and unexpected scenarios improved both the reliability and quality of the code.

---