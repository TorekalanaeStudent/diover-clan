// ========================================
// ✅ AFTER — GOOD DESIGN (Refactored Code)
// ========================================

// SOLID: SRP - OrderService only orchestrates, does NOT validate/map/resolve
// SOLID: OCP - Adding new payment = just add new @Component class, never touch this
// SOLID: DIP - Depends on abstractions (interfaces), not concrete classes
// OOP: Composition over Inheritance - uses injected collaborators

@Service
public class OrderService {

    // ✅ DIP - all are interfaces/abstractions
    private final OrderRepository orderRepository;     // interface
    private final OrderValidator orderValidator;       // extracted SRP class
    private final PaymentResolver paymentResolver;     // replaces switch statement
    private final OrderMapper orderMapper;             // extracted SRP class

    public OrderService(OrderRepository orderRepository,
                        OrderValidator orderValidator,
                        PaymentResolver paymentResolver,
                        OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.paymentResolver = paymentResolver;
        this.orderMapper = orderMapper;
    }

    public OrderDTO createOrder(CreateOrderRequest request) {
        // ✅ SRP - validation fully delegated, not mixed here
        orderValidator.validate(request);

        Order order = new Order(request.getCustomerName());
        for (OrderItemDTO itemDTO : request.getItems()) {
            order.addItem(new OrderItem(
                    itemDTO.getProductName(),
                    itemDTO.getPrice(),
                    itemDTO.getQuantity()
            ));
        }

        Order saved = orderRepository.save(order);

        // ✅ OCP - PaymentResolver handles lookup, no switch needed here
        if (request.getPaymentType() != null) {
            Payment payment = paymentResolver.resolve(request.getPaymentType());
            if (payment != null) payment.process(saved.calculateTotal());
        }

        // ✅ SRP - mapping fully delegated
        return orderMapper.toDTO(saved);
    }
}