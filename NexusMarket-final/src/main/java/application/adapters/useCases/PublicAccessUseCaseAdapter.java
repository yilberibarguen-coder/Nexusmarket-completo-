package application.adapters.useCases;

import application.NexusMarketApplication;
import application.domain.model.*;
import application.domain.ports.in.*;
import java.math.*;
import java.util.*;

/** Application-layer adapter: role input port -> concrete domain services. */
public final class PublicAccessUseCaseAdapter implements PublicAccessPort {
    private final NexusMarketApplication application;

    public PublicAccessUseCaseAdapter(NexusMarketApplication application) { this.application = Objects.requireNonNull(application); }

    @Override
    public String login(String username, String password) {
        return application.login.login(username, password);
    }

    @Override
    public Customer register(User actor, Customer customer) {
        return application.registerCustomer.register(actor, customer);
    }

    @Override
    public Product consultProduct(User actor, String productId) {
        return application.consultProduct.consultProduct(actor, productId);
    }

    @Override
    public List<Product> searchProducts(User actor, String text, String categoryId, String sellerId, BigDecimal minPrice, BigDecimal maxPrice, boolean onlyAvailable) {
        return application.searchProducts.searchProducts(actor, text, categoryId, sellerId, minPrice, maxPrice, onlyAvailable);
    }

}
