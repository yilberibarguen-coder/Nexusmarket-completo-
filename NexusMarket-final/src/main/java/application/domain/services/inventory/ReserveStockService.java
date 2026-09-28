package application.domain.services.inventory;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ReserveStockService implements ReserveStockUseCase {
private final InventoryRepositoryPort inventories; private final ProductRepositoryPort products; private final OperationAuditPort audit; public ReserveStockService(InventoryRepositoryPort i,ProductRepositoryPort p,OperationAuditPort a){inventories=i;products=p;audit=a;}
public Inventory reserveStock(User actor,String pid,int quantity){ServiceSupport.role(actor,"SELLER","ADMIN");Product p=ServiceSupport.required(products.findById(pid),"Product",pid);Inventory inv=ServiceSupport.required(inventories.findByProduct(p),"Inventory",pid);inv.reserve(quantity);inventories.update(inv);audit.record(actor,"RESERVE_STOCK",pid,Map.of("quantity",quantity));return inv;}
}
