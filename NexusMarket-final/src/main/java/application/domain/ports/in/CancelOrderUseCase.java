package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface CancelOrderUseCase {
        Order cancelOrder(User actor, String orderId);
    }
