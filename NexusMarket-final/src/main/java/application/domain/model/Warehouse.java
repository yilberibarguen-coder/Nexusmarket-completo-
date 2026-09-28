package application.domain.model;
public class Warehouse {
    private final String id;
    private String name;
    private final Address address;
    private boolean active = true;
    public Warehouse(String id, String name, Address address) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) throw new IllegalArgumentException("Warehouse id and name are required");
        this.id = id; this.name = name; this.address = address;
    }
    public String getId(){return id;} public String getName(){return name;} public Address getAddress(){return address;} public boolean isActive(){return active;}
    public void rename(String name){if(name==null||name.isBlank())throw new IllegalArgumentException("Warehouse name is required");this.name=name;}
    public void deactivate(){active=false;} public void activate(){active=true;}
}
