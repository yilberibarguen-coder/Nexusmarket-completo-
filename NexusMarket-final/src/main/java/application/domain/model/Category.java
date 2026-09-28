package application.domain.model;
public class Category {
    private final String id; private String name,description; private boolean active=true;
    public Category(String id,String name){if(id==null||id.isBlank()||name==null||name.isBlank())throw new IllegalArgumentException("Invalid category");this.id=id;this.name=name;}
    public String getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
    public void update(String name,String description){if(name==null||name.isBlank())throw new IllegalArgumentException("Name is required");this.name=name;this.description=description;}
    public void deactivate(){active=false;} public void activate(){active=true;} public boolean isActive(){return active;}
}
