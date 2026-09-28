package application.domain.model;
import application.domain.enums.MovementType;
import java.time.Instant;
public record InventoryMovement(String id, String productId, String warehouseId, int quantity, MovementType type, Instant timestamp) {
    public InventoryMovement { if(id==null||id.isBlank()||productId==null||productId.isBlank()||warehouseId==null||warehouseId.isBlank()||quantity<=0||type==null) throw new IllegalArgumentException("Invalid inventory movement"); if(timestamp==null) timestamp=Instant.now(); }
}
