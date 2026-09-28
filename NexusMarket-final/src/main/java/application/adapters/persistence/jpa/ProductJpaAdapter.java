package application.adapters.persistence.jpa;
import application.adapters.persistence.jpa.mappers.ProductJpaMapper;
import application.adapters.persistence.jpa.repositories.ProductJpaRepository;
import application.domain.model.*;
import application.domain.ports.out.ProductRepositoryPort;
import java.math.BigDecimal; import java.util.*;
/** Output adapter boundary. Replace ProductJpaRepository with Spring Data JPA in infrastructure deployment. */
public final class ProductJpaAdapter implements ProductRepositoryPort {
    private final ProductJpaRepository repository;
    private final Map<String,Product> domainCache=new HashMap<>();
    public ProductJpaAdapter(ProductJpaRepository repository){this.repository=repository;}
    public Product save(Product p){repository.save(ProductJpaMapper.toEntity(p));domainCache.put(p.getId(),p);return p;}
    public Optional<Product> findById(String id){return Optional.ofNullable(domainCache.get(id));}
    public List<Product> findAll(){return List.copyOf(domainCache.values());}
    public void update(Product p){save(p);}
    public List<Product> search(String text,String categoryId,String sellerId,BigDecimal min,BigDecimal max,boolean onlyAvailable){return domainCache.values().stream().filter(p->text==null||text.isBlank()||p.getName().toLowerCase().contains(text.toLowerCase())).filter(p->categoryId==null||(p.getCategory()!=null&&categoryId.equals(p.getCategory().getId()))).filter(p->sellerId==null||(p.getSeller()!=null&&sellerId.equals(p.getSeller().getId()))).filter(p->min==null||p.getPrice().compareTo(min)>=0).filter(p->max==null||p.getPrice().compareTo(max)<=0).filter(p->!onlyAvailable||p.getStatus()==application.domain.enums.ProductStatus.PUBLISHED).toList();}
}
