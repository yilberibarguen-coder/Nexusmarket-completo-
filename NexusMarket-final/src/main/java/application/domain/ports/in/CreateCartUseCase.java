package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface CreateCartUseCase {
        Cart createCart(User actor, Customer customer, String cartId);
    }
