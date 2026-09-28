package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ManageWishlistUseCase {
        Wishlist manageWishlist(User actor, String customerId, Product product, String operation);
    }
