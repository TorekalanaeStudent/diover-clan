# Obedoza GRASP + SOLID Lab

## Principles Applied

### GRASP (Previous Lab)
- Information Expert: Order.calculateTotal()
- Creator: Order.addItem()
- Controller: OrderController
- Low Coupling: interfaces throughout
- High Cohesion: one responsibility per class
- Polymorphism: PaymentProcessor interface
- Pure Fabrication: OrderValidator, OrderService
- Indirection: OrderRepository
- Protected Variations: interfaces shield from change

### SOLID (This Lab)
- SRP: Each class has one job
- OCP: New payments added without modifying existing code
- LSP: All PaymentProcessor implementations are interchangeable
- ISP: OrderQueryService and OrderCommandService split
- DIP: All dependencies are interfaces

### OOP Best Practices
- DRY: Shared buildOrder() helper in tests
- KISS: Simple, readable method names
- YAGNI: No unused methods or fields
- Immutability: OrderSummary record, OrderNotFoundException
- Composition: PaymentProcessor map over inheritance

## Test Coverage
- JaCoCo: 92%
- Total Tests: 10+

## How to Run
mvn clean test
open target/site/jacoco/index.html


## Review and Retrospect

**Which principle improved design most?**
DIP — injecting interfaces instead of concrete classes made
everything independently testable with Mockito.

**What bad design did you remove?**
Replaced generic RuntimeException with OrderNotFoundException (SRP).
Split OrderService into Query and Command interfaces (ISP).

**Which principle was hardest to apply?**
ISP — deciding how to split interfaces without over-engineering it.

