package application.adapters.rest.controllers;
import application.adapters.rest.dtos.responses.ProductResponse;
import application.domain.model.Product;
import application.domain.model.User;
import application.domain.ports.in.SearchProductsUseCase;
import java.math.BigDecimal; import java.util.List;
public final class ProductRestController {
    private final SearchProductsUseCase searchProductsUseCase;
    public ProductRestController(SearchProductsUseCase useCase){this.searchProductsUseCase=useCase;}
    public List<ProductResponse> search(User user,String text,String categoryId,String sellerId,BigDecimal min,BigDecimal max,boolean onlyAvailable){return searchProductsUseCase.searchProducts(user,text,categoryId,sellerId,min,max,onlyAvailable).stream().map(ProductResponse::from).toList();}
}
