# Before vs After Refactoring Evidence

## SRP

Before:

```java
// Validation existed, but some edge cases were not handled.
if (request.getItems() == null || request.getItems().isEmpty()) {
    throw new InvalidOrderException("Order must contain at least one item");
}
```

After:

```java
// SOLID: SRP - handles only order request validation.
private void validateItem(OrderRequest.OrderItemRequest item) {
    if (item == null) {
        throw new InvalidOrderException("Order item must not be null");
    }
}
```

Why: Validation rules are centralized in `OrderValidator`, keeping controllers, entities, and services cleaner.

## OCP and DIP

Before:

```java
PaymentProcessor processor = processors.get(methodKey.toUpperCase());
```

Issue: Blank or null method keys could fail poorly, and key normalization was hardcoded in one lookup path.

After:

```java
// SOLID: OCP - new processors are added as beans.
// DIP: Depends on PaymentProcessor abstraction.
PaymentProcessor processor = processors.get(normalize(methodKey));
```

Why: `PaymentProcessorFactory` now uses one normalization method for both registration and lookup and rejects invalid input cleanly.

## Immutability

Before:

```java
OrderResponse resp = new OrderResponse();
resp.items = order.getItems().stream()
        .map(ItemResponse::from)
        .collect(Collectors.toList());
```

Issue: DTO state was mutable inside the class and list immutability was not explicit.

After:

```java
private final List<ItemResponse> items;
this.items = List.copyOf(items);
```

Why: The response is now an immutable snapshot of the order.

## Composition Over Inheritance

Good design already existed:

```java
private List<OrderItem> items = new ArrayList<>();
```

Why: `Order` has `OrderItem` objects instead of forcing an inheritance hierarchy. This follows composition over inheritance and keeps the aggregate simple.

## Good Existing Design

- `OrderController` already followed SRP by delegating business logic to `OrderService`.
- `OrderRepository` already supported DIP because services depend on a repository interface.
- Payment processors already supported polymorphism because each implementation used the same `PaymentProcessor` contract.
