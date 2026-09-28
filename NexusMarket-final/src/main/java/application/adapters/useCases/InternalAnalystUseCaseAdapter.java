package application.adapters.useCases;

import application.NexusMarketApplication;
import application.domain.model.*;
import application.domain.ports.in.*;
import java.math.*;
import java.util.*;

/** Application-layer adapter: role input port -> concrete domain services. */
public final class InternalAnalystUseCaseAdapter implements InternalAnalystPort {
    private final NexusMarketApplication application;

    public InternalAnalystUseCaseAdapter(NexusMarketApplication application) { this.application = Objects.requireNonNull(application); }

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
    public List<Product> searchProducts(User actor, String text, String categoryId, String sellerId, BigDecimal minPrice, BigDecimal maxPrice, boolean onlyAvailable) {
        return application.searchProducts.searchProducts(actor, text, categoryId, sellerId, minPrice, maxPrice, onlyAvailable);
    }

    @Override
    public Inventory consultInventory(User actor, String productId) {
        return application.consultInventory.consultInventory(actor, productId);
    }

    @Override
    public Order consultOrder(User actor, String orderId) {
        return application.consultOrder.consultOrder(actor, orderId);
    }

}
