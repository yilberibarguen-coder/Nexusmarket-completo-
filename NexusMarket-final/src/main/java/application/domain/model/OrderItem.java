package application.domain.model;
import java.math.*;
public record OrderItem(Product product,int quantity,BigDecimal unitPrice) { public BigDecimal total(){return unitPrice.multiply(BigDecimal.valueOf(quantity));} }
