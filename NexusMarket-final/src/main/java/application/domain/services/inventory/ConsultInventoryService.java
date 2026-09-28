package application.domain.services.inventory;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ConsultInventoryService implements ConsultInventoryUseCase {
private final InventoryRepositoryPort inventories; private final ProductRepositoryPort products; public ConsultInventoryService(InventoryRepositoryPort i,ProductRepositoryPort p){inventories=i;products=p;}
public Inventory consultInventory(User actor,String pid){ServiceSupport.actor(actor);Product p=ServiceSupport.required(products.findById(pid),"Product",pid);return ServiceSupport.required(inventories.findByProduct(p),"Inventory",pid);}
}
