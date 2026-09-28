package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface RequestReturnUseCase {
        ReturnRequest requestReturn(User actor, String orderId, String returnId, Product product, int quantity, String reason);
    }
