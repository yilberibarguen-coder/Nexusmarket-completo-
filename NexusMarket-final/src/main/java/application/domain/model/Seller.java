package application.domain.model;
import java.util.*;
public class Seller extends Person { private final List<Product> products=new ArrayList<>(); public Seller(String id,String name,String email,String phone){super(id,name,email,phone);} public List<Product> getProducts(){return products;} public void addProduct(Product p){products.add(p);} }
