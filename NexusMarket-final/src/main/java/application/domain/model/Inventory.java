package application.domain.model;
import java.util.*;
public class Inventory {
    private final String id; private final Product product; private final Warehouse warehouse; private int available; private int reserved; private final List<InventoryMovement> movements=new ArrayList<>();
    public Inventory(String id,Product product,int initial){this(id,product,null,initial);}
    public Inventory(String id,Product product,Warehouse warehouse,int initial){if(id==null||id.isBlank()||product==null)throw new IllegalArgumentException("Inventory id and product are required");if(initial<0)throw new IllegalArgumentException("Stock cannot be negative");this.id=id;this.product=product;this.warehouse=warehouse;available=initial;}
    public String getId(){return id;} public int getAvailable(){return available;} public int getReserved(){return reserved;} public Product getProduct(){return product;} public Warehouse getWarehouse(){return warehouse;} public List<InventoryMovement> getMovements(){return List.copyOf(movements);}
    public void increase(int q){if(q<=0)throw new IllegalArgumentException("Quantity must be positive");available+=q;record(q,application.domain.enums.MovementType.INFLOW);}
    public void decrease(int q){if(q<=0||q>available)throw new IllegalArgumentException("Insufficient stock");available-=q;record(q,application.domain.enums.MovementType.SALE);}
    public void reserve(int q){if(q<=0||q>available)throw new IllegalArgumentException("Insufficient stock");available-=q;reserved+=q;record(q,application.domain.enums.MovementType.RESERVATION);}
    public void release(int q){if(q<=0||q>reserved)throw new IllegalArgumentException("Invalid reservation");reserved-=q;available+=q;record(q,application.domain.enums.MovementType.RETURN);}
    private void record(int q,application.domain.enums.MovementType type){String warehouseId=warehouse==null?"DEFAULT":warehouse.getId();movements.add(new InventoryMovement(UUID.randomUUID().toString(),product.getId(),warehouseId,q,type,java.time.Instant.now()));}
}
