package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface RegisterPaymentUseCase {
        Payment registerPayment(User actor, String orderId, String paymentId, BigDecimal amount, boolean approved);
    }
