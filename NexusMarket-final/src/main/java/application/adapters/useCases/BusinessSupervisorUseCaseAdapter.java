package application.adapters.useCases;

import application.NexusMarketApplication;
import application.domain.model.*;
import application.domain.ports.in.*;
import java.math.*;
import java.util.*;

/** Application-layer adapter: role input port -> concrete domain services. */
public final class BusinessSupervisorUseCaseAdapter implements BusinessSupervisorPort {
    private final NexusMarketApplication application;

    public BusinessSupervisorUseCaseAdapter(NexusMarketApplication application) { this.application = Objects.requireNonNull(application); }

    @Override
    public Customer consult(User actor, String customerId) {
        return application.consultCustomer.consult(actor, customerId);
    }

    @Override
    public List<Order> consultOrders(User actor, String customerId) {
        return application.consultCustomerOrders.consultOrders(actor, customerId);
    }

    @Override
    public User consultUser(User actor, String userId) {
        return application.consultUser.consultUser(actor, userId);
    }

    @Override
    public Product consultProduct(User actor, String productId) {
        return application.consultProduct.consultProduct(actor, productId);
    }

    @Override
    public Inventory consultInventory(User actor, String productId) {
        return application.consultInventory.consultInventory(actor, productId);
    }

    @Override
    public Order consultOrder(User actor, String orderId) {
        return application.consultOrder.consultOrder(actor, orderId);
    }

    @Override
    public Customer changeStatus(User actor, String customerId, DomainTypes.Status status) {
        return application.changeCustomerStatus.changeStatus(actor, customerId, status);
    }

    @Override
    public User changeUserStatus(User actor, String userId, application.domain.enums.UserStatus status) {
        return application.changeUserStatus.changeUserStatus(actor, userId, status);
    }

    @Override
    public Product changeProductStatus(User actor, String productId, application.domain.enums.ProductStatus status) {
        return application.changeProductStatus.changeProductStatus(actor, productId, status);
    }

    @Override
    public ReturnRequest approveReturn(User actor, String returnId, boolean approve) {
        return application.approveReturn.approveReturn(actor, returnId, approve);
    }

    @Override
    public Refund processRefund(User actor, String returnId, String refundId) {
        return application.processRefund.processRefund(actor, returnId, refundId);
    }

    @Override
    public List<Product> searchProducts(User actor, String text, String categoryId, String sellerId, BigDecimal minPrice, BigDecimal maxPrice, boolean onlyAvailable) {
        return application.searchProducts.searchProducts(actor, text, categoryId, sellerId, minPrice, maxPrice, onlyAvailable);
    }

}
