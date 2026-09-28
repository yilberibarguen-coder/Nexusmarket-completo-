package application.domain.model;
import application.domain.enums.InvoiceStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public class Invoice {
    private final String id; private final String number; private final Order order; private final BigDecimal total; private final LocalDateTime issuedAt; private InvoiceStatus status;
    public Invoice(String id,String number,Order order,BigDecimal total){
        if(id==null||id.isBlank()||number==null||number.isBlank()||order==null||total==null||total.signum()<0) throw new IllegalArgumentException("Invalid invoice");
        this.id=id;this.number=number;this.order=order;this.total=total;this.issuedAt=LocalDateTime.now();this.status=InvoiceStatus.ISSUED;
    }
    public String getId(){return id;} public String getNumber(){return number;} public Order getOrder(){return order;} public BigDecimal getTotal(){return total;} public LocalDateTime getIssuedAt(){return issuedAt;} public InvoiceStatus getStatus(){return status;}
    public void voidInvoice(){if(status==InvoiceStatus.REFUNDED)throw new IllegalStateException("Refunded invoice cannot be voided");status=InvoiceStatus.VOIDED;}
    public void markRefunded(){status=InvoiceStatus.REFUNDED;}
}
