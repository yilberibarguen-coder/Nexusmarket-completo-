package application.adapters.persistence.inmemory;
import application.domain.model.*; import application.domain.ports.out.ProductRepositoryPort; import java.util.*; import java.util.concurrent.ConcurrentHashMap; import java.math.*;
public class InMemoryProductAdapter implements ProductRepositoryPort {
 private final Map<String,Product> data=new ConcurrentHashMap<>();
 public Product save(Product p){data.put(p.getId(),p);return p;} public Optional<Product> findById(String id){return Optional.ofNullable(data.get(id));} public List<Product> findAll(){return List.copyOf(data.values());} public void update(Product p){data.put(p.getId(),p);}
 public List<Product> search(String text,String categoryId,String sellerId,BigDecimal min,BigDecimal max,boolean available){return data.values().stream().filter(p->text==null||text.isBlank()||p.getName().toLowerCase().contains(text.toLowerCase())||(p.getDescription()!=null&&p.getDescription().toLowerCase().contains(text.toLowerCase()))).filter(p->categoryId==null||p.getCategory()!=null&&categoryId.equals(p.getCategory().getId())).filter(p->sellerId==null||p.getSeller()!=null&&sellerId.equals(p.getSeller().getId())).filter(p->min==null||p.getPrice().compareTo(min)>=0).filter(p->max==null||p.getPrice().compareTo(max)<=0).filter(p->!available||p.getStatus()==application.domain.enums.ProductStatus.PUBLISHED).toList();}
}
