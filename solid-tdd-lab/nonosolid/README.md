# SOLID + OOP Best Practices Lab — Products (Nono)

## Run
Open in IntelliJ → Load Maven Project → Run `ApplApplication.java`

- App: http://localhost:8080/api/products
- H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:productdb`, user: `sa`, password: blank)

## SOLID Principles Applied
| Principle | Where |
|-----------|-------|
| SRP | `ProductValidator` extracted from `ProductService` |
| OCP | `DiscountStrategy` interface + `PercentageDiscountStrategy`, `FlatDiscountStrategy` |
| LSP | Both strategies/notifiers substitute their interfaces safely |
| ISP | `DiscountStrategy` and `Notifier` are small, focused interfaces |
| DIP | `ProductService` injects `DiscountStrategy` and `Notifier` — no concrete imports |

## OOP Best Practices
- **Encapsulation**: all `Product` fields private
- **Immutability**: `ProductSnapshot` is a Java record (all fields final)
- **Polymorphism**: multiple `DiscountStrategy` and `Notifier` implementations

## GRASP Principles
- **Information Expert**: `Product.isAvailable()`, `Product.hasDiscount()`
- **Controller**: `ProductController` delegates to service
- **Pure Fabrication**: `ProductMapper`, `ProductService`
- **Indirection**: `ProductRepository`
- **Protected Variations**: `GlobalExceptionHandler`, `ProductNotFoundException`

## Test Coverage
| Test Class | Tests | What it covers |
|------------|-------|----------------|
| `ProductServiceTest` | 12 | Mockito mocks, DIP, edge cases, verify notify |
| `ProductControllerTest` | 7 | HTTP status, MockMvc, 404 handling |
| `ProductEntityTest` | 8 | Information Expert, Immutability, Parameterized |
| `ProductMapperTest` | 5 | Pure Fabrication, discount application |
| `ApplApplicationTests` | 1 | Context loads |
