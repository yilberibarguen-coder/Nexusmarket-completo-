package application.domain.services.inventory;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class IncreaseStockService implements IncreaseStockUseCase {
private final InventoryRepositoryPort inventories; private final ProductRepositoryPort products; private final OperationAuditPort audit; public IncreaseStockService(InventoryRepositoryPort i,ProductRepositoryPort p,OperationAuditPort a){inventories=i;products=p;audit=a;}
public Inventory increaseStock(User actor,String pid,int quantity){ServiceSupport.role(actor,"SELLER","ADMIN");Product p=ServiceSupport.required(products.findById(pid),"Product",pid);Inventory inv=ServiceSupport.required(inventories.findByProduct(p),"Inventory",pid);inv.increase(quantity);inventories.update(inv);audit.record(actor,"INCREASE_STOCK",pid,Map.of("quantity",quantity));return inv;}
}
