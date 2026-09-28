package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface CreateInventoryUseCase {
        Inventory createInventory(User actor, Inventory inventory);
    }
