package application.adapters.useCases;

import application.NexusMarketApplication;
import application.domain.model.*;
import application.domain.ports.in.*;
import java.math.*;
import java.util.*;

/** Application-layer adapter: role input port -> concrete domain services. */
public final class NaturalCustomerUseCaseAdapter implements NaturalCustomerPort {
    private final NexusMarketApplication application;

    public NaturalCustomerUseCaseAdapter(NexusMarketApplication application) { this.application = Objects.requireNonNull(application); }

    @Override
    public Product consultProduct(User actor, String productId) {
        return application.consultProduct.consultProduct(actor, productId);
    }

    @Override
    public List<Product> searchProducts(User actor, String text, String categoryId, String sellerId, BigDecimal minPrice, BigDecimal maxPrice, boolean onlyAvailable) {
        return application.searchProducts.searchProducts(actor, text, categoryId, sellerId, minPrice, maxPrice, onlyAvailable);
    }

    @Override
    public Cart createCart(User actor, Customer customer, String cartId) {
        return application.createCart.createCart(actor, customer, cartId);
    }

    @Override
    public Cart addProduct(User actor, String customerId, String productId, int quantity) {
        return application.addProductToCart.addProduct(actor, customerId, productId, quantity);
    }

    @Override
    public Cart removeProduct(User actor, String customerId, String productId) {
        return application.removeProductFromCart.removeProduct(actor, customerId, productId);
    }

    @Override
    public Cart clearCart(User actor, String customerId) {
        return application.clearCart.clearCart(actor, customerId);
    }

    @Override
    public Wishlist manageWishlist(User actor, String customerId, Product product, String operation) {
        return application.manageWishlist.manageWishlist(actor, customerId, product, operation);
    }

    @Override
    public Customer manageAddresses(User actor, String customerId, Address address, String operation) {
        return application.manageCustomerAddresses.manageAddresses(actor, customerId, address, operation);
    }

    @Override
    public Order createOrder(User actor, String customerId, String orderId) {
        return application.createOrder.createOrder(actor, customerId, orderId);
    }

    @Override
    public Order consultOrder(User actor, String orderId) {
        return application.consultOrder.consultOrder(actor, orderId);
    }

    @Override
    public List<Order> consultOrders(User actor, String customerId) {
        return application.consultCustomerOrders.consultOrders(actor, customerId);
    }

    @Override
    public BigDecimal calculateOrderTotal(User actor, String orderId) {
        return application.calculateOrderTotal.calculateOrderTotal(actor, orderId);
    }

    @Override
    public Payment registerPayment(User actor, String orderId, String paymentId, BigDecimal amount, boolean approved) {
        return application.registerPayment.registerPayment(actor, orderId, paymentId, amount, approved);
    }

    @Override
    public Order confirmOrder(User actor, String orderId) {
        return application.confirmOrder.confirmOrder(actor, orderId);
    }

    @Override
    public Order cancelOrder(User actor, String orderId) {
        return application.cancelOrder.cancelOrder(actor, orderId);
    }

    @Override
    public ReturnRequest requestReturn(User actor, String orderId, String returnId, Product product, int quantity, String reason) {
        return application.requestReturn.requestReturn(actor, orderId, returnId, product, quantity, reason);
    }

}
