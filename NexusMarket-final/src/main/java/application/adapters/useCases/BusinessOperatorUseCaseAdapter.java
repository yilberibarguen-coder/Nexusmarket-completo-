package application.adapters.useCases;

import application.NexusMarketApplication;
import application.domain.model.*;
import application.domain.ports.in.*;
import java.math.*;
import java.util.*;

/** Application-layer adapter: role input port -> concrete domain services. */
public final class BusinessOperatorUseCaseAdapter implements BusinessOperatorPort {
    private final NexusMarketApplication application;

    public BusinessOperatorUseCaseAdapter(NexusMarketApplication application) { this.application = Objects.requireNonNull(application); }

    @Override
    public Product createProduct(User actor, Product product) {
        return application.createProduct.createProduct(actor, product);
    }

    @Override
    public Product consultProduct(User actor, String productId) {
        return application.consultProduct.consultProduct(actor, productId);
    }

    @Override
    public Product updateProduct(User actor, Product product) {
        return application.updateProduct.updateProduct(actor, product);
    }

    @Override
    public Product changeProductStatus(User actor, String productId, application.domain.enums.ProductStatus status) {
        return application.changeProductStatus.changeProductStatus(actor, productId, status);
    }

    @Override
    public Product assignCategory(User actor, String productId, String categoryId) {
        return application.assignProductCategory.assignCategory(actor, productId, categoryId);
    }

    @Override
    public Category createCategory(User actor, Category category) {
        return application.createCategory.createCategory(actor, category);
    }

    @Override
    public Category updateCategory(User actor, Category category, String name, String description) {
        return application.updateCategory.updateCategory(actor, category, name, description);
    }

    @Override
    public List<Product> searchProducts(User actor, String text, String categoryId, String sellerId, BigDecimal minPrice, BigDecimal maxPrice, boolean onlyAvailable) {
        return application.searchProducts.searchProducts(actor, text, categoryId, sellerId, minPrice, maxPrice, onlyAvailable);
    }

    @Override
    public Inventory createInventory(User actor, Inventory inventory) {
        return application.createInventory.createInventory(actor, inventory);
    }

    @Override
    public Inventory consultInventory(User actor, String productId) {
        return application.consultInventory.consultInventory(actor, productId);
    }

    @Override
    public Inventory increaseStock(User actor, String productId, int quantity) {
        return application.increaseStock.increaseStock(actor, productId, quantity);
    }

    @Override
    public Inventory decreaseStock(User actor, String productId, int quantity) {
        return application.decreaseStock.decreaseStock(actor, productId, quantity);
    }

    @Override
    public Inventory reserveStock(User actor, String productId, int quantity) {
        return application.reserveStock.reserveStock(actor, productId, quantity);
    }

    @Override
    public Order consultOrder(User actor, String orderId) {
        return application.consultOrder.consultOrder(actor, orderId);
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

}
