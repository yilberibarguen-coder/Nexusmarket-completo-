package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface RemoveProductFromCartUseCase {
        Cart removeProduct(User actor, String customerId, String productId);
    }
