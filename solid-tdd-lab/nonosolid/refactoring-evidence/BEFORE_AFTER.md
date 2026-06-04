git# Refactoring Evidence — SOLID + OOP Best Practices

## 1. SRP — Single Responsibility Principle

### BEFORE (violation): Validation inside ProductService
```java
// ProductService.java — doing too many things
public ProductResponse createProduct(ProductRequest request) {
    // Validation mixed into service
    if (request.getName() == null || request.getName().isBlank()) {
        throw new IllegalArgumentException("Name required");
    }
    if (request.getPrice() < 0) {
        throw new IllegalArgumentException("Invalid price");
    }
    // ... then save
}
```

### AFTER (fixed): Validation extracted to ProductValidator
```java
// ProductValidator.java — only validates
public void validate(ProductRequest request) { ... }

// ProductService.java — only orchestrates
public ProductResponse createProduct(ProductRequest request) {
    productValidator.validate(request);  // delegate
    Product product = productMapper.toEntity(request);
    return productMapper.toResponse(productRepository.save(product), discountStrategy);
}
```

---

## 2. OCP — Open/Closed Principle

### BEFORE (violation): Discount logic inside service with if/else
```java
// Hard-coded; adding new discount type = editing this method
public double calculatePrice(Product p) {
    if (type.equals("percentage")) return p.getPrice() * 0.9;
    if (type.equals("flat")) return p.getPrice() - 50;
    return p.getPrice();
}
```

### AFTER (fixed): DiscountStrategy interface + implementations
```java
// Open for extension, closed for modification
public interface DiscountStrategy {
    double applyDiscount(double price);
}
// Add SeasonalDiscountStrategy without touching existing code
```

---

## 3. DIP — Dependency Inversion Principle

### BEFORE (violation): Service creates its own concrete dependencies
```java
public class ProductService {
    private LogNotifier notifier = new LogNotifier(); // tightly coupled
}
```

### AFTER (fixed): Injected through constructor via interface
```java
public class ProductService {
    private final Notifier notifier; // depends on abstraction
    public ProductService(..., Notifier notifier, ...) {
        this.notifier = notifier; // injected — swap without editing service
    }
}
```

---

## 4. LSP — Liskov Substitution Principle

Both `PercentageDiscountStrategy` and `FlatDiscountStrategy` substitute `DiscountStrategy`
without breaking any caller. Both `LogNotifier` and `EmailNotifier` substitute `Notifier`
without breaking `ProductService`.

---

## 5. ISP — Interface Segregation Principle

### BEFORE (violation): Fat interface forcing unused methods
```java
interface ProductOperations {
    void save(); void delete(); void notify(); void validate(); void map();
}
```

### AFTER (fixed): Small focused interfaces
```java
interface DiscountStrategy { double applyDiscount(double price); }
interface Notifier         { void notify(String message); }
```

---

## 6. Immutability — OOP Best Practice

### ProductSnapshot (Java record)
```java
public record ProductSnapshot(Long id, String name, String category,
                               Double price, int stockQuantity) {}
```
- All fields `final` — cannot be changed after creation
- Auto-generated `equals`, `hashCode`, `toString`
- Modifying the source `Product` does NOT affect the snapshot

---

## 7. Encapsulation — OOP Best Practice

All `Product` fields are `private`. Access is only through getters/setters.
Domain behaviour (`isAvailable()`, `hasDiscount()`) lives inside the entity
rather than being computed externally — GRASP: Information Expert.
