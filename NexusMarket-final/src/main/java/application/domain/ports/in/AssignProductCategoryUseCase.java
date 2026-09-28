package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface AssignProductCategoryUseCase {
        Product assignCategory(User actor, String productId, String categoryId);
    }
