package application;

import application.domain.enums.UserRole;
import application.adapters.rest.security.JwtUserReconstructor;
import application.domain.model.*;
import java.math.BigDecimal;

/** Framework-free smoke test covering the main marketplace flow. */
public final class NexusMarketSmokeTest {
    public static void main(String[] args) {
        NexusMarketApplication app = new NexusMarketApplication();
        User admin = new User("u-admin","admin","admin",UserRole.ADMIN);
        Seller seller = new Seller("s-1","Seller","seller@nexus.test","3000000000");
        User sellerUser = new User("u-seller","seller","seller",UserRole.SELLER);
        Customer customer = new Customer("c-1","Buyer","buyer@nexus.test","3000000001");
        User buyer = new User("u-buyer","buyer","buyer",UserRole.BUYER);
        buyer.linkCustomer(customer);

        app.registerCustomer.register(null, customer);
        app.registerCustomerUser.registerCustomerUser(null, customer, buyer);
        String token=app.login.login("buyer","buyer");
        if(token==null||token.split("\\.").length!=3) throw new AssertionError("JWT generation failed");
        User reconstructed=new JwtUserReconstructor(app.jwtTokens).reconstruct(token);
        if(reconstructed.getRole()!=UserRole.BUYER) throw new AssertionError("JWT role reconstruction failed");
        app.products.save(new Product("p-1","Laptop",new BigDecimal("2500.00"),seller));
        Product product = app.products.findById("p-1").orElseThrow();
        Category category = new Category("cat-1","Technology");
        app.createCategory.createCategory(admin, category);
        app.assignProductCategory.assignCategory(sellerUser,"p-1","cat-1");
        app.createInventory.createInventory(sellerUser,new Inventory("inv-1",product,10));
        app.createCart.createCart(buyer,customer,"cart-1");
        app.naturalCustomer.consultProduct(buyer,"p-1");
        app.addProductToCart.addProduct(buyer,"c-1","p-1",2);
        Order order=app.createOrder.createOrder(buyer,"c-1","ord-1");
        app.registerPayment.registerPayment(buyer,"ord-1","pay-1",order.getTotal(),true);
        app.confirmOrder.confirmOrder(buyer,"ord-1");
        if(order.getStatus()!=application.domain.model.DomainTypes.OrderStatus.PAID) throw new AssertionError("Order should be PAID");
        if(app.inventories.findByProduct(product).orElseThrow().getAvailable()!=8) throw new AssertionError("Inventory reservation failed");
        System.out.println("NexusMarket smoke test: PASS");
    }
}
