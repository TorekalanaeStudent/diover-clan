# Navarro SOLID + OOP Unit Testing Lab

This project reuses the existing Spring Boot order application and improves it with SOLID principles, OOP best practices, and focused Mockito/JUnit 5 tests.

## What Was Improved

- `OrderService` already followed SRP reasonably well because it handled order lifecycle business logic only and delegated HTTP, validation, payment selection, and persistence.
- `OrderValidator` was strengthened for SRP and DRY by owning all order request validation, including null items, blank payment method, and invalid item values.
- `PaymentProcessorFactory` was improved for OCP and DIP. It now depends on `PaymentProcessor` abstractions, normalizes keys in one reusable method, rejects null/blank payment methods cleanly, and uses an unmodifiable processor map.
- `PaymentProcessor` demonstrates ISP because the interface remains small and focused. Implementations also demonstrate LSP because each processor can be used through the same contract.
- `OrderResponse` was refactored into an immutable DTO. It exposes getters only and protects its item list using `List.copyOf`.
- `Order` keeps a composition relationship with `OrderItem`, using a HAS-A aggregate instead of inheritance.

## SOLID Mapping

- SRP: `OrderValidator` validates only orders, `OrderResponse` maps only response data, `OrderController` handles only HTTP routing.
- OCP: New payment methods can be added by creating a new `PaymentProcessor` implementation.
- LSP: `CreditCardPaymentProcessor`, `PayPalPaymentProcessor`, and `BankTransferPaymentProcessor` all work through `PaymentProcessor`.
- ISP: `PaymentProcessor` is intentionally small and avoids a fat payment interface.
- DIP: `OrderService` and `PaymentProcessorFactory` depend on abstractions injected by Spring/Mockito.

## OOP Best Practices

- DRY: Shared normalization in `PaymentProcessorFactory` and shared blank validation in `OrderValidator`.
- KISS: No unnecessary layers were added; the refactor stays close to the existing design.
- YAGNI: Only current business rules were implemented.
- Composition over inheritance: `Order` owns `OrderItem` objects.
- Immutability: `OrderResponse` and returned item collections are read-only.

## Tests

Run:

```bash
./gradlew.bat test
```

Current result: `BUILD SUCCESSFUL`

Meaningful tests include:

- Service layer tests using mocked repositories and dependencies.
- Dependency inversion proof using mocked `PaymentProcessor` interfaces.
- Polymorphism/LSP tests across multiple payment implementations.
- Immutability validation for `Order` and `OrderResponse`.
- Edge cases for null values, empty collections, invalid input, unsupported payments, and missing records.

## Evidence

See `refactoring-evidence/` for:

- Before vs after examples.
- TDD red-green-refactor notes.
- Test result summary.
- Screen recording checklist/notes.
