package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class CreateProductService implements CreateProductUseCase { private final ProductRepositoryPort products; private final OperationAuditPort audit; private final AuthorizationPort auth;
 public CreateProductService(ProductRepositoryPort p,OperationAuditPort a,AuthorizationPort auth){products=p;audit=a;this.auth=auth;}
 public Product createProduct(User actor,Product p){ServiceSupport.role(actor,"SELLER","ADMIN");if(products.findById(p.getId()).isPresent())throw new ConflictException("Product already exists");if(p.getSeller()==null)throw new DomainRuleException("Seller is required");Product saved=products.save(p);audit.record(actor,"CREATE_PRODUCT",saved.getId(),Map.of("price",saved.getPrice()));return saved;}
}
