package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface CreateOrderUseCase {
        Order createOrder(User actor, String customerId, String orderId);
    }
