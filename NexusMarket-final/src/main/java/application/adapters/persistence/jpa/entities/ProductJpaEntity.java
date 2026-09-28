package application.adapters.persistence.jpa.entities;
import java.math.BigDecimal;
/** Persistence DTO intentionally separated from the domain Product aggregate. */
public final class ProductJpaEntity {
    private String id,name,description,sellerId,categoryId,type,status; private BigDecimal price;
    public String getId(){return id;} public void setId(String v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public String getSellerId(){return sellerId;} public void setSellerId(String v){sellerId=v;} public String getCategoryId(){return categoryId;} public void setCategoryId(String v){categoryId=v;} public String getType(){return type;} public void setType(String v){type=v;} public String getStatus(){return status;} public void setStatus(String v){status=v;} public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
}
