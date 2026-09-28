package application.adapters.rest.dtos.responses;
import application.domain.model.Product;
public record ProductResponse(String id,String name,String description,String price,String type,String status,String categoryId,String sellerId) {
    public static ProductResponse from(Product p){return new ProductResponse(p.getId(),p.getName(),p.getDescription(),p.getPrice().toPlainString(),p.getType().name(),p.getStatus().name(),p.getCategory()==null?null:p.getCategory().getId(),p.getSeller()==null?null:p.getSeller().getId());}
}
