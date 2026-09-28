package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ConsultCustomerOrdersUseCase {
        List<Order> consultOrders(User actor, String customerId);
    }
