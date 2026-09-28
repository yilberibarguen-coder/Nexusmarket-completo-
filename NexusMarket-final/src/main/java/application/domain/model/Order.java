package application.domain.model;
import java.util.*; import java.math.*;
public class Order {
    private final String id; private final Customer customer; private final List<OrderItem> items=new ArrayList<>();
    private DomainTypes.OrderStatus status=DomainTypes.OrderStatus.CREATED; private BigDecimal total=BigDecimal.ZERO; private Invoice invoice;
    public Order(String id,Customer customer){this.id=id;this.customer=customer;}
    public void addItem(Product p,int q){items.add(new OrderItem(p,q,p.getPrice()));}
    public BigDecimal calculateTotal(){total=items.stream().map(OrderItem::total).reduce(BigDecimal.ZERO,BigDecimal::add);return total;}
    public void changeStatus(DomainTypes.OrderStatus s){status=s;}
    public String getId(){return id;} public Customer getCustomer(){return customer;} public List<OrderItem> getItems(){return List.copyOf(items);}
    public DomainTypes.OrderStatus getStatus(){return status;} public BigDecimal getTotal(){return total;} public Invoice getInvoice(){return invoice;} public void attachInvoice(Invoice invoice){if(invoice==null||invoice.getOrder()!=this)throw new IllegalArgumentException("Invoice must belong to this order");this.invoice=invoice;}
}
