package application.adapters.useCases;

import application.NexusMarketApplication;
import application.domain.model.*;
import application.domain.ports.in.*;
import java.math.*;
import java.util.*;

/** Application-layer adapter: role input port -> concrete domain services. */
public final class TellerEmployeeUseCaseAdapter implements TellerEmployeePort {
    private final NexusMarketApplication application;

    public TellerEmployeeUseCaseAdapter(NexusMarketApplication application) { this.application = Objects.requireNonNull(application); }

    @Override
    public Customer consult(User actor, String customerId) {
        return application.consultCustomer.consult(actor, customerId);
    }

    @Override
    public Order consultOrder(User actor, String orderId) {
        return application.consultOrder.consultOrder(actor, orderId);
    }

    @Override
    public Payment registerPayment(User actor, String orderId, String paymentId, BigDecimal amount, boolean approved) {
        return application.registerPayment.registerPayment(actor, orderId, paymentId, amount, approved);
    }

    @Override
    public Order updateOrderStatus(User actor, String orderId, DomainTypes.OrderStatus status) {
        return application.updateOrderStatus.updateOrderStatus(actor, orderId, status);
    }

    @Override
    public Shipment createShipment(User actor, String orderId, String shipmentId, Address address) {
        return application.createShipment.createShipment(actor, orderId, shipmentId, address);
    }

    @Override
    public Shipment updateShipmentStatus(User actor, String shipmentId, DomainTypes.ShipmentStatus status) {
        return application.updateShipmentStatus.updateShipmentStatus(actor, shipmentId, status);
    }

    @Override
    public ReturnRequest approveReturn(User actor, String returnId, boolean approve) {
        return application.approveReturn.approveReturn(actor, returnId, approve);
    }

    @Override
    public Refund processRefund(User actor, String returnId, String refundId) {
        return application.processRefund.processRefund(actor, returnId, refundId);
    }

}
