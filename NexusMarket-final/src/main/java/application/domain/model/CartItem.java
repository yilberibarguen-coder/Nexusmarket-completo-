package application.domain.model;
import java.math.*;
public record CartItem(Product product,int quantity,BigDecimal unitPrice) { public CartItem {if(quantity<=0)throw new IllegalArgumentException("Quantity must be positive");} public BigDecimal total(){return unitPrice.multiply(BigDecimal.valueOf(quantity));} }
