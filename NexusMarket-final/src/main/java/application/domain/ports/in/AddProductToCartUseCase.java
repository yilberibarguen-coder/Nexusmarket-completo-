package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface AddProductToCartUseCase {
        Cart addProduct(User actor, String customerId, String productId, int quantity);
    }
