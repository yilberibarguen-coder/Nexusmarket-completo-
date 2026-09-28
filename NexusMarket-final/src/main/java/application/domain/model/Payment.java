package application.domain.model;
import java.math.*;
public class Payment {
    private final String id; private final Order order; private final BigDecimal amount; private DomainTypes.PaymentStatus status=DomainTypes.PaymentStatus.PENDING;
    public Payment(String id,Order order,BigDecimal amount){if(amount==null||amount.signum()<=0)throw new IllegalArgumentException("Amount must be positive");this.id=id;this.order=order;this.amount=amount;}
    public String getId(){return id;} public void approve(){status=DomainTypes.PaymentStatus.APPROVED;} public void decline(){status=DomainTypes.PaymentStatus.DECLINED;}
    public DomainTypes.PaymentStatus getStatus(){return status;} public BigDecimal getAmount(){return amount;} public Order getOrder(){return order;}
}
