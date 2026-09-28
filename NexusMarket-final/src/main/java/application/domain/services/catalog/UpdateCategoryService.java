package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class UpdateCategoryService implements UpdateCategoryUseCase { private final CategoryRepositoryPort categories; private final OperationAuditPort audit; public UpdateCategoryService(CategoryRepositoryPort c,OperationAuditPort a){categories=c;audit=a;}
 public Category updateCategory(User actor,Category c,String name,String description){ServiceSupport.role(actor,"ADMIN");Category stored=ServiceSupport.required(categories.findById(c.getId()),"Category",c.getId());stored.update(name,description);categories.update(stored);audit.record(actor,"UPDATE_CATEGORY",c.getId(),Map.of());return stored;}
}
