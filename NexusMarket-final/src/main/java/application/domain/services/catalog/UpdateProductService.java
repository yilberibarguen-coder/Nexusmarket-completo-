package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class UpdateProductService implements UpdateProductUseCase { private final ProductRepositoryPort products; private final OperationAuditPort audit;
 public UpdateProductService(ProductRepositoryPort p,OperationAuditPort a){products=p;audit=a;}
 public Product updateProduct(User actor,Product p){ServiceSupport.role(actor,"SELLER","ADMIN");Product stored=ServiceSupport.required(products.findById(p.getId()),"Product",p.getId());if("SELLER".equalsIgnoreCase(actor.getRole().name())&&(stored.getSeller()==null||!stored.getSeller().getId().equals(actor.getId())))throw new UnauthorizedException("Seller does not own product");stored.update(p.getName(),p.getDescription(),p.getPrice());products.update(stored);audit.record(actor,"UPDATE_PRODUCT",p.getId(),Map.of());return stored;}
}
