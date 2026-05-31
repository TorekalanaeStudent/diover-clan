# Refactoring Journey: Improving Design and Integrity

This project evolved from a data-centric structure to a behavior-centric architecture that prioritizes security, maintainability, and clean separation of concerns.

**Submitted by:** @flcardeno Cardeño, Faye L. 

---

# 1. The Refactor: Improving SRP

I realized that `TaskService` was doing too much: it was coordinating the flow **and** checking if the data was valid. I followed the **Single Responsibility Principle (SRP)** by extracting the validation logic into a dedicated `TaskValidator` class.

## Before

Validation logic was inside the `createTask` method.

### Code

```java
public class TaskService {

    private final TaskRepository repo;
    private final List<NotificationStrategy> notifiers;

    public Task createTask(TaskDTO dto) {
        if (dto == null) throw new IllegalArgumentException("Task cannot be null");
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title is required");
        }

        Task task = new Task(null, dto.getTitle(), dto.getDueDate(), false);
        Task savedTask = repo.save(task);

        notifiers.forEach(n -> n.send(savedTask));

        return savedTask;
    }
}
```

## After

`TaskService` simply calls `validator.validate(dto)`. This makes the service easier to read and the validator easier to test on its own.

### Code

```java
public Task createTask(TaskDTO dto) {
    validator.validate(dto);
}
```

### Code

```java
public class TaskValidator {
    public void validate(TaskDTO dto) {
        if (dto == null) throw new IllegalArgumentException("Task cannot be null");
        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Task title is required");
        }
    }
}
```
## Why I Changed It

I wanted `TaskService` to focus only on task operations. By moving validation into its own class, the code became cleaner and easier to maintain.

---

# 2. Improving DIP: Strengthening Abstraction

I wanted to reduce the dependency between the service and validation logic. This helps make the code more flexible and easier to test.


## Before

The service was handling validation directly, making it tightly coupled to its own internal logic.

### Code

```java
public Task createTask(TaskDTO dto) {
    // Service was responsible for direct validation logic
    if (dto == null) // ...

    Task savedTask = repo.save(task);
    notifiers.forEach(n -> n.send(savedTask));
    return savedTask;
}
```

## After

By utilizing `TaskValidator` and final fields, I ensured the service focuses only on orchestration.

### Code

```java
public class TaskService {
    private final TaskRepository repo;
    private final List<NotificationStrategy> notifiers;
    private final TaskValidator validator; // Injected abstraction

    public Task createTask(TaskDTO dto) {
        validator.validate(dto);
        Task task = new Task(null, dto.getTitle(), dto.getDueDate(), false);
        Task savedTask = repo.save(task);
        notifiers.forEach(n -> n.send(savedTask));
        return savedTask;
    }
}
```
## Why I Changed It

I wanted the service to focus on coordinating tasks instead of handling every detail itself. This made the code more organized and easier to test.

---

# 3. Improving Data Protection: API/DTO Separation

I noticed that the controller was returning the database entity directly to the client. This could expose internal information that clients do not need to see.

## Before

The controller returned the `Task` entity directly.

### Code

```java
@PostMapping
public ResponseEntity<Task> create(@RequestBody TaskDTO dto) {
    Task createdTask = service.createTask(dto);
    return ResponseEntity.ok(createdTask); // Leaks internal entity structure
}
```

## After

The controller now returns a `TaskResponse` DTO, ensuring that only the data intended for the client is sent.

### Code

```java
@PostMapping
public ResponseEntity<TaskResponse> create(@RequestBody TaskDTO dto) {
    Task savedTask = service.createTask(dto);

    // Transforming to a DTO hides the internal database structure
    TaskResponse response = new TaskResponse(
        savedTask.getId(),
        savedTask.getTitle()
    );

    return ResponseEntity.ok(response);
}
```
## Why I Changed It

I wanted to control what information is sent to the client and prevent exposing unnecessary internal data.

---

# 4. Improving Robustness: Centralized Exception Handling

I refactored the application to use a `GlobalExceptionHandler`. This follows the **Single Responsibility Principle** by removing error-handling logic from the Service and Controller.

## Before

Each service or controller method would have to manually use try-catch blocks, leading to duplicate code and inconsistent error formats.

## After

I created a `GlobalExceptionHandler` that handles exceptions in one place.

### Code

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles your existing TaskNotFoundException
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TaskNotFoundException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );
    }

    // Handles validation errors
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleValidation(IllegalArgumentException ex) {
        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    // Handles unexpected server errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(
                "An internal error occurred: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
```
## Why I Changed It

I wanted all errors to be handled consistently while keeping my controllers and services cleaner.

---

# 5. Improving Encapsulation: Protecting Domain State

I wanted to better protect the data inside the `Task` entity and prevent other classes from changing it freely.

## Before

The entity used `@Setter`, allowing any class to modify its fields.

### Code

```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    // ...
}
```

## After

I removed `@Setter` so that the entity's state could not be modified directly.

### Code

```java
@Entity
@Getter // OOP: Immutability - Removing @Setter protects object state integrity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    // ...
}
```
## Why I Changed It

I wanted to protect the object's state and reduce the risk of unintended changes to the data.

---

# Conclusion

By applying SOLID principles and object-oriented design practices, I was able to make the project cleaner, more organized, and easier to maintain. 

---