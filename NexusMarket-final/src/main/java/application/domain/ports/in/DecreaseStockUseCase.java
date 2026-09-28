package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface DecreaseStockUseCase {
        Inventory decreaseStock(User actor, String productId, int quantity);
    }
