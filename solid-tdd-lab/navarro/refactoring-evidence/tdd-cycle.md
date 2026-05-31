# Red-Green-Refactor Cycle

## Cycle 1: Payment Factory Input Handling

Red:

- Added a test for blank payment method lookup.
- Expected `UnsupportedPaymentMethodException` instead of accidental `NullPointerException` or inconsistent lookup behavior.

Green:

- Added `normalize(String methodKey)` in `PaymentProcessorFactory`.
- Reused it for both registration and lookup.

Refactor:

- Changed processor map to `Collectors.toUnmodifiableMap`.
- Added SOLID comments for OCP and DIP.

## Cycle 2: Validator Edge Cases

Red:

- Added tests for null request, empty items, invalid item quantity, and missing payment method.

Green:

- Added item-level validation and a shared `isBlank` helper.

Refactor:

- Kept validation in `OrderValidator` only to preserve SRP and avoid bloating `OrderService`.

## Cycle 3: Immutability

Red:

- Added tests that try to mutate `Order.getItems()` and `OrderResponse.getItems()`.

Green:

- Kept `Order.getItems()` unmodifiable.
- Refactored `OrderResponse` to final fields and `List.copyOf`.

Refactor:

- Preserved existing getter-based API so controllers and tests did not need a large rewrite.

## Cycle 4: Polymorphism

Red:

- Added a parameterized test using all real payment implementations through `PaymentProcessor`.

Green:

- Verified each implementation returns a valid transaction id through the same interface.

Refactor:

- Added interface comments for ISP and LSP.
