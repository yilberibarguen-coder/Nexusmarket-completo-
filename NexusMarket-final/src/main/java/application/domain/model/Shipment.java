package application.domain.model;
public class Shipment {
    private final String id; private final Order order; private final Address address; private DomainTypes.ShipmentStatus status=DomainTypes.ShipmentStatus.CREATED;
    public Shipment(String id,Order order,Address address){this.id=id;this.order=order;this.address=address;}
    public String getId(){return id;} public DomainTypes.ShipmentStatus getStatus(){return status;} public Order getOrder(){return order;} public Address getAddress(){return address;}
    public void changeStatus(DomainTypes.ShipmentStatus s){status=s;}
}
