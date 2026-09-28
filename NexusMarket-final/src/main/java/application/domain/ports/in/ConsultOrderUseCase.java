package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ConsultOrderUseCase {
        Order consultOrder(User actor, String orderId);
    }
