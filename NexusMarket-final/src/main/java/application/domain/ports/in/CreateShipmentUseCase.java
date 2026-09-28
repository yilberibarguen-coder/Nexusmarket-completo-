package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface CreateShipmentUseCase {
        Shipment createShipment(User actor, String orderId, String shipmentId, Address address);
    }
