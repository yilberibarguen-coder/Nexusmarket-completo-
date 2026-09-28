package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface IncreaseStockUseCase {
        Inventory increaseStock(User actor, String productId, int quantity);
    }
