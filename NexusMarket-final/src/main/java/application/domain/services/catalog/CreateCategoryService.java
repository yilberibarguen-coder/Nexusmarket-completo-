package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class CreateCategoryService implements CreateCategoryUseCase { private final CategoryRepositoryPort categories; private final OperationAuditPort audit; public CreateCategoryService(CategoryRepositoryPort c,OperationAuditPort a){categories=c;audit=a;}
 public Category createCategory(User actor,Category c){ServiceSupport.role(actor,"ADMIN");if(categories.findById(c.getId()).isPresent())throw new ConflictException("Category already exists");Category saved=categories.save(c);audit.record(actor,"CREATE_CATEGORY",c.getId(),Map.of());return saved;}
}
