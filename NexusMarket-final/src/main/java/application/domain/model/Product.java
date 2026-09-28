package application.domain.model;
import application.domain.enums.ProductType;
import application.domain.enums.ProductStatus;
import java.math.*;
public class Product {
    private final String id; private String name,description; private BigDecimal price;
    private final ProductType type; private Category category; private Seller seller; private ProductStatus status=ProductStatus.PUBLISHED;
    public Product(String id,String name,BigDecimal price,Seller seller){this(id,name,price,seller,ProductType.PHYSICAL);}
    public Product(String id,String name,BigDecimal price,Seller seller,ProductType type){
        if(id==null||id.isBlank()||name==null||name.isBlank()) throw new IllegalArgumentException("Product id and name are required");
        if(price==null||price.signum()<=0) throw new IllegalArgumentException("Price must be positive");
        if(type==null) throw new IllegalArgumentException("Product type is required");
        this.id=id;this.name=name;this.price=price;this.seller=seller;this.type=type;
    }
    public String getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
    public BigDecimal getPrice(){return price;} public ProductType getType(){return type;} public Category getCategory(){return category;} public Seller getSeller(){return seller;}
    public ProductStatus getStatus(){return status;}
    public void update(String name,String description,BigDecimal price){if(name==null||name.isBlank()||price==null||price.signum()<=0)throw new IllegalArgumentException("Invalid product data");this.name=name;this.description=description;this.price=price;}
    public void setCategory(Category c){this.category=c;} public void changeStatus(ProductStatus s){if(s==null)throw new IllegalArgumentException("Status is required");this.status=s;}
}
