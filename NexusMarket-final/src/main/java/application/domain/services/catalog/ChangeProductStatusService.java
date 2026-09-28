package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ChangeProductStatusService implements ChangeProductStatusUseCase { private final ProductRepositoryPort products; private final OperationAuditPort audit; public ChangeProductStatusService(ProductRepositoryPort p,OperationAuditPort a){products=p;audit=a;}
 public Product changeProductStatus(User actor,String id,application.domain.enums.ProductStatus status){ServiceSupport.role(actor,"SELLER","ADMIN");Product p=ServiceSupport.required(products.findById(id),"Product",id);p.changeStatus(status);products.update(p);audit.record(actor,"CHANGE_PRODUCT_STATUS",id,Map.of("status",status.name()));return p;}
}
