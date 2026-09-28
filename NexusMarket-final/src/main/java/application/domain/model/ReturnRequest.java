package application.domain.model;
public class ReturnRequest {
    private final String id; private final Order order; private final Product product; private final int quantity; private final String reason; private boolean approved; private boolean rejected;
    public ReturnRequest(String id,Order order,String reason){this(id,order,null,1,reason);}
    public ReturnRequest(String id,Order order,Product product,int quantity,String reason){if(quantity<=0)throw new IllegalArgumentException("Quantity must be positive");this.id=id;this.order=order;this.product=product;this.quantity=quantity;this.reason=reason;}
    public String getId(){return id;} public Order getOrder(){return order;} public Product getProduct(){return product;} public int getQuantity(){return quantity;} public String getReason(){return reason;}
    public void approve(){approved=true;rejected=false;} public void reject(){rejected=true;approved=false;} public boolean isApproved(){return approved;} public boolean isRejected(){return rejected;}
}
