package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface UpdateShipmentStatusUseCase {
        Shipment updateShipmentStatus(User actor, String shipmentId, DomainTypes.ShipmentStatus status);
    }
