package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface SearchProductsUseCase {
        List<Product> searchProducts(User actor, String text, String categoryId, String sellerId, BigDecimal minPrice, BigDecimal maxPrice, boolean onlyAvailable);
    }
