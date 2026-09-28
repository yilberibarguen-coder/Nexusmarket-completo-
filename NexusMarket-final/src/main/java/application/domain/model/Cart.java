package application.domain.model;
import java.util.*; import java.math.*;
public class Cart {
    private final String id; private final Customer owner; private final List<CartItem> items=new ArrayList<>();
    public Cart(String id,Customer owner){this.id=id;this.owner=owner;}
    public String getId(){return id;} public Customer getOwner(){return owner;} public List<CartItem> getItems(){return List.copyOf(items);}
    public void add(Product p,int q){if(q<=0)throw new IllegalArgumentException("Quantity must be positive");for(int i=0;i<items.size();i++){CartItem x=items.get(i);if(x.product().getId().equals(p.getId())){items.set(i,new CartItem(p,x.quantity()+q,p.getPrice()));return;}}items.add(new CartItem(p,q,p.getPrice()));}
    public void remove(String productId){items.removeIf(i->i.product().getId().equals(productId));}
    public void clear(){items.clear();} public BigDecimal total(){return items.stream().map(CartItem::total).reduce(BigDecimal.ZERO,BigDecimal::add);}
}
