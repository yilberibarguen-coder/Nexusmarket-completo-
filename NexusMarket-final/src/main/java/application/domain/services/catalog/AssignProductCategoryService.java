package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class AssignProductCategoryService implements AssignProductCategoryUseCase { private final ProductRepositoryPort products; private final CategoryRepositoryPort categories; private final OperationAuditPort audit;
 public AssignProductCategoryService(ProductRepositoryPort p,CategoryRepositoryPort c,OperationAuditPort a){products=p;categories=c;audit=a;}
 public Product assignCategory(User actor,String pid,String cid){ServiceSupport.role(actor,"SELLER","ADMIN");Product p=ServiceSupport.required(products.findById(pid),"Product",pid);Category c=ServiceSupport.required(categories.findById(cid),"Category",cid);if(!c.isActive())throw new IllegalArgumentException("Category is inactive");p.setCategory(c);products.update(p);audit.record(actor,"ASSIGN_PRODUCT_CATEGORY",pid,Map.of("categoryId",cid));return p;}
}
