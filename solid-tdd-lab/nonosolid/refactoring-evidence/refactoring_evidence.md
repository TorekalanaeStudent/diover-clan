# Refactoring Evidence — SOLID + OOP Best Practices
**Student:** Nono  
**Lab:** SOLID + Unit Testing Lab  
**System:** Product Management System  

---

## 1. SRP — Single Responsibility Principle

### ❌ BEFORE (Violation)
Validation logic was mixed directly inside `ProductService`, giving it **two responsibilities**: orchestrating business logic AND validating input.

```java
// ProductService.java — BEFORE (doing too many things)
public ProductResponse createProduct(ProductRequest request) {
    // Responsibility 1: Validation (should NOT be here)
    if (request.getName() == null || request.getName().isBlank()) {
        throw new IllegalArgumentException("Product name cannot be empty");
    }
    if (request.getPrice() == null || request.getPrice() < 0) {
        throw new IllegalArgumentException("Price must be non-negative");
    }
    if (request.getStockQuantity() < 0) {
        throw new IllegalArgumentException("Stock must be non-negative");
    }

    // Responsibility 2: Business logic (saving the product)
    Product product = productMapper.toEntity(request);
    Product saved = productRepository.save(product);
    return productMapper.toResponse(saved, discountStrategy);
}
```

**Problem:** If validation rules change, you must edit `ProductService` — violating SRP.

---

### ✅ AFTER (Fixed)
Validation extracted into its own class `ProductValidator`. Now each class has **one reason to change**.

```java
// ProductValidator.java — AFTER (only validates)
@Component
public class ProductValidator {
    public void validate(ProductRequest request) {
        if (request == null)
            throw new IllegalArgumentException("Request cannot be null");
        if (request.getName() == null || request.getName().isBlank())
            throw new IllegalArgumentException("Product name cannot be empty");
        if (request.getPrice() == null || request.getPrice() < 0)
            throw new IllegalArgumentException("Price must be non-negative");
        if (request.getStockQuantity() < 0)
            throw new IllegalArgumentException("Stock must be non-negative");
    }
}

// ProductService.java — AFTER (only orchestrates)
public ProductResponse createProduct(ProductRequest request) {
    productValidator.validate(request);  // delegate to specialist
    Product product = productMapper.toEntity(request);
    Product saved = productRepository.save(product);
    notifier.notify("New product created: " + saved.getName());
    return productMapper.toResponse(saved, discountStrategy);
}
```

**Result:** Changing validation rules only touches `ProductValidator`. `ProductService` is untouched.

---

## 2. OCP — Open/Closed Principle

### ❌ BEFORE (Violation)
Discount logic was hard-coded inside the service using if/else. Adding a new discount type required **editing existing code**.

```java
// ProductService.java — BEFORE
public double calculateDiscountedPrice(Product product, String discountType) {
    if (discountType.equals("percentage")) {
        return product.getPrice() * 0.90; // 10% off
    } else if (discountType.equals("flat")) {
        return product.getPrice() - 50.0;
    }
    return product.getPrice(); // no discount
    // Adding "seasonal" discount = edit this method = OCP violation
}
```

---

### ✅ AFTER (Fixed)
Introduced `DiscountStrategy` interface. New discount types are added by **creating a new class**, never editing existing ones.

```java
// DiscountStrategy.java — interface (closed for modification)
public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
}

// PercentageDiscountStrategy.java — new class (open for extension)
public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percentageOff;
    public PercentageDiscountStrategy(double percentageOff) {
        this.percentageOff = percentageOff;
    }
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice - (originalPrice * percentageOff / 100.0);
    }
}

// FlatDiscountStrategy.java — another extension, zero edits to existing code
public class FlatDiscountStrategy implements DiscountStrategy {
    private final double flatAmount;
    @Override
    public double applyDiscount(double originalPrice) {
        return Math.max(originalPrice - flatAmount, 0.0);
    }
}
```

**Result:** Adding a `SeasonalDiscountStrategy` = create one new file. Zero changes to `ProductService` or `ProductMapper`.

---

## 3. LSP — Liskov Substitution Principle

### ❌ BEFORE (Violation)
`FlatDiscountStrategy` could return a negative price, breaking the contract that any `DiscountStrategy` returns a valid price.

```java
// BEFORE — FlatDiscountStrategy could return negative price
public double applyDiscount(double originalPrice) {
    return originalPrice - flatAmount; // if price=30 and flatAmount=50 → returns -20 ❌
}
```

---

### ✅ AFTER (Fixed)
Both strategies honor the contract: discounted price is always ≥ 0. Substituting one for the other never breaks behavior.

```java
// AFTER — FlatDiscountStrategy respects LSP
public double applyDiscount(double originalPrice) {
    return Math.max(originalPrice - flatAmount, 0.0); // never negative ✅
}

// AFTER — PercentageDiscountStrategy also validates its own state
public PercentageDiscountStrategy(double percentageOff) {
    if (percentageOff < 0 || percentageOff > 100)
        throw new IllegalArgumentException("Percentage must be between 0 and 100");
    this.percentageOff = percentageOff;
}
```

**Result:** `DiscountStrategy discount = new FlatDiscountStrategy(50)` can replace `new PercentageDiscountStrategy(10)` anywhere, and the system still works correctly.

---

## 4. ISP — Interface Segregation Principle

### ❌ BEFORE (Violation)
One large interface forced all implementors to provide methods they didn't need.

```java
// BEFORE — Fat interface
public interface ProductOperations {
    void save(Product p);
    void delete(Long id);
    void notify(String message);     // not all classes send notifications
    void validate(ProductRequest r); // not all classes validate
    double applyDiscount(double p);  // not all classes discount
}
```

---

### ✅ AFTER (Fixed)
Split into small, focused interfaces. Each class only implements what it actually needs.

```java
// Small interface 1: only for discounting
public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
}

// Small interface 2: only for notifications
public interface Notifier {
    void notify(String message);
}

// LogNotifier only needs to implement Notifier — nothing else
public class LogNotifier implements Notifier {
    @Override
    public void notify(String message) {
        log.info("[NOTIFICATION] {}", message);
    }
}
```

**Result:** `LogNotifier` is not forced to implement `applyDiscount`. `PercentageDiscountStrategy` is not forced to implement `notify`.

---

## 5. DIP — Dependency Inversion Principle

### ❌ BEFORE (Violation)
`ProductService` created its own concrete dependencies — tightly coupled to specific classes.

```java
// ProductService.java — BEFORE (tightly coupled)
public class ProductService {
    // High-level module depending on low-level concrete classes ❌
    private LogNotifier notifier = new LogNotifier();
    private PercentageDiscountStrategy discount = new PercentageDiscountStrategy(10);

    public ProductResponse createProduct(ProductRequest request) {
        // Can't swap notifier or discount without editing this file
        notifier.notify("Product created");
        ...
    }
}
```

---

### ✅ AFTER (Fixed)
`ProductService` depends only on **interfaces**. Concrete classes are injected via `AppConfig`.

```java
// ProductService.java — AFTER (depends on abstractions)
@Service
public class ProductService {
    private final DiscountStrategy discountStrategy; // interface ✅
    private final Notifier notifier;                 // interface ✅

    // Constructor injection — Spring provides the concrete class
    public ProductService(..., DiscountStrategy discountStrategy, Notifier notifier, ...) {
        this.discountStrategy = discountStrategy;
        this.notifier = notifier;
    }
}

// AppConfig.java — wiring happens here, not in the service
@Configuration
public class AppConfig {
    @Bean
    public DiscountStrategy discountStrategy() {
        return new PercentageDiscountStrategy(10.0); // swap here only
    }
    @Bean
    public Notifier notifier() {
        return new LogNotifier(); // swap to EmailNotifier here — service is untouched
    }
}
```

**Result:** Swap `LogNotifier` → `EmailNotifier` by editing only `AppConfig`. `ProductService` code is **never touched**.

---

## 6. OOP Best Practice: Immutability

### ❌ BEFORE (No Immutability)
Product data was passed around as mutable objects — any code could accidentally modify shared state.

```java
// BEFORE — mutable object shared across layers
Product product = productRepository.findById(1L).get();
auditLog.record(product); // audit stores reference
product.setPrice(0.0);    // accidentally mutates what auditLog holds ❌
```

---

### ✅ AFTER (Fixed with ProductSnapshot)
`ProductSnapshot` is a Java record — all fields are `final`. No setters exist.

```java
// ProductSnapshot.java — immutable value object
public record ProductSnapshot(
    Long id, String name, String category,
    Double price, int stockQuantity
) {
    public static ProductSnapshot from(Product product) {
        return new ProductSnapshot(product.getId(), product.getName(),
            product.getCategory(), product.getPrice(), product.getStockQuantity());
    }
}

// Usage — snapshot is frozen at the time of creation
ProductSnapshot snapshot = ProductSnapshot.from(product);
product.setPrice(0.0);           // mutate original
System.out.println(snapshot.price()); // still 999.99 ✅ — snapshot unaffected
```

**Result:** Safe audit logs, price history, and data sharing — no accidental mutation possible.

---

## Summary Table

| Principle | Violation (Before) | Fix (After) |
|-----------|-------------------|-------------|
| SRP | Validation in `ProductService` | Extracted to `ProductValidator` |
| OCP | Discount if/else in service | `DiscountStrategy` interface + implementations |
| LSP | `FlatDiscountStrategy` returned negative price | `Math.max(..., 0.0)` enforces contract |
| ISP | One fat interface for everything | Separate `DiscountStrategy` and `Notifier` interfaces |
| DIP | Service created its own concrete classes | Constructor injection via interfaces + `AppConfig` |
| Immutability | Mutable `Product` shared everywhere | `ProductSnapshot` Java record (all fields final) |
