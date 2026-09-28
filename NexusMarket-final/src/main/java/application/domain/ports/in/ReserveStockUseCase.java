package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ReserveStockUseCase {
        Inventory reserveStock(User actor, String productId, int quantity);
    }
