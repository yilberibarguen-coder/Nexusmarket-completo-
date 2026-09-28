package application.domain.model;
import java.util.*;
public class Wishlist { private final Customer owner; private final Set<Product> products=new HashSet<>(); public Wishlist(Customer owner){this.owner=owner;} public Customer getOwner(){return owner;} public void add(Product p){if(p!=null)products.add(p);} public void remove(Product p){if(p!=null)products.remove(p);} public Set<Product> getProducts(){return Set.copyOf(products);} }
