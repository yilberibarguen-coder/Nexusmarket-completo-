package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ChangeProductStatusUseCase {
        Product changeProductStatus(User actor, String productId, application.domain.enums.ProductStatus status);
    }
