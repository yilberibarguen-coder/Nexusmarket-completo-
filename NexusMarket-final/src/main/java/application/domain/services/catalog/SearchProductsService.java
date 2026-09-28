package application.domain.services.catalog;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.math.*; import java.util.*;
public class SearchProductsService implements SearchProductsUseCase { private final ProductRepositoryPort products; public SearchProductsService(ProductRepositoryPort p){products=p;}
 public List<Product> searchProducts(User actor,String text,String categoryId,String sellerId,BigDecimal minPrice,BigDecimal maxPrice,boolean onlyAvailable){ServiceSupport.actor(actor);return products.search(text,categoryId,sellerId,minPrice,maxPrice,onlyAvailable);}
}
