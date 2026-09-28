package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface UpdateCategoryUseCase {
        Category updateCategory(User actor, Category category, String name, String description);
    }
