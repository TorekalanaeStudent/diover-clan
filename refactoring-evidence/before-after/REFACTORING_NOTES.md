# Refactoring Evidence — Jagunap

## 1. SRP Violation Fixed
**Before:** `OrderService.createOrder()` handled validation, mapping, payment, AND saving all in one method.
**After:** Split into `OrderValidator`, `OrderMapper`, `PaymentResolver`, and `OrderService`.

## 2. OCP Violation Fixed
**Before:** `resolvePaymentKey()` used a switch statement — adding a new payment type required editing OrderService.
**After:** `PaymentResolver` uses the Spring bean map. Adding new payment = just add a new `@Component` class.

## 3. Good Design Already Present
- **DIP ✅** — `OrderRepository` is an interface; service never touches JPA directly.
- **LSP ✅** — `CashPayment`, `CreditCardPayment`, `GcashPayment` all substitute `Payment` correctly.
- **ISP ✅** — `Payment` interface is small and focused (2 methods only).
- **Immutability ✅** — Added `OrderSnapshot` as a value object with no setters.
- **YAGNI ✅** — No unused features or speculative code added.
- **KISS ✅** — Each class is small and does one thing.

## 4. Principles Summary
| Principle | Where Applied |
|-----------|--------------|
| SRP | OrderValidator, OrderMapper, PaymentResolver |
| OCP | PaymentResolver replaces switch statement |
| LSP | All Payment implementations |
| ISP | Payment interface (2 methods only) |
| DIP | OrderService depends on interfaces only |
| DRY | OrderValidator centralizes all validation |
| Immutability | OrderSnapshot has no setters |