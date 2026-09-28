package application.adapters.persistence.jpa.mappers;
import application.adapters.persistence.jpa.entities.ProductJpaEntity;
import application.domain.model.Product;
public final class ProductJpaMapper {
    private ProductJpaMapper(){}
    public static ProductJpaEntity toEntity(Product p){ProductJpaEntity e=new ProductJpaEntity();e.setId(p.getId());e.setName(p.getName());e.setDescription(p.getDescription());e.setPrice(p.getPrice());e.setType(p.getType().name());e.setStatus(p.getStatus().name());e.setSellerId(p.getSeller()==null?null:p.getSeller().getId());e.setCategoryId(p.getCategory()==null?null:p.getCategory().getId());return e;}
}
