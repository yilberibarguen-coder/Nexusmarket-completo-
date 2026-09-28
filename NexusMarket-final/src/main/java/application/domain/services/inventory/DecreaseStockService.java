package application.domain.services.inventory;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class DecreaseStockService implements DecreaseStockUseCase {
private final InventoryRepositoryPort inventories; private final ProductRepositoryPort products; private final OperationAuditPort audit; public DecreaseStockService(InventoryRepositoryPort i,ProductRepositoryPort p,OperationAuditPort a){inventories=i;products=p;audit=a;}
public Inventory decreaseStock(User actor,String pid,int quantity){ServiceSupport.role(actor,"SELLER","ADMIN");Product p=ServiceSupport.required(products.findById(pid),"Product",pid);Inventory inv=ServiceSupport.required(inventories.findByProduct(p),"Inventory",pid);inv.decrease(quantity);inventories.update(inv);audit.record(actor,"DECREASE_STOCK",pid,Map.of("quantity",quantity));return inv;}
}
