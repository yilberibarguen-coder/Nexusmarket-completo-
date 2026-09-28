package application.domain.model;
import java.util.*;
public class Customer extends Person {
    private final List<Address> addresses = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    public Customer(String id,String name,String email,String phone){super(id,name,email,phone);}
    public String getName(){return name;}
    public String getPhone(){return phone;}
    public List<Address> getAddresses(){return List.copyOf(addresses);}
    public List<Order> getOrders(){return List.copyOf(orders);}
    public void update(String name,String email,String phone){
        if(name==null||name.isBlank()||email==null||email.isBlank()) throw new IllegalArgumentException("Name and email are required");
        this.name=name; this.email=email; this.phone=phone;
    }
    public void addAddress(Address a){if(a==null) throw new IllegalArgumentException("Address is required"); addresses.add(a);}
    public void updateAddress(Address a){for(int i=0;i<addresses.size();i++) if(addresses.get(i).id().equals(a.id())){addresses.set(i,a);return;} throw new IllegalArgumentException("Address not found");}
    public void removeAddress(String addressId){addresses.removeIf(a->a.id().equals(addressId));}
    public void addOrder(Order o){orders.add(o);}
}
