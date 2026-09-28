package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ConfirmOrderUseCase {
        Order confirmOrder(User actor, String orderId);
    }
