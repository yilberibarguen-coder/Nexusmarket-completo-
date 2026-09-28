package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ProcessRefundUseCase {
        Refund processRefund(User actor, String returnId, String refundId);
    }
