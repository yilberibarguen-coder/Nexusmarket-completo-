package application.domain.services.cart;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class CreateCartService implements CreateCartUseCase { private final CartRepositoryPort carts; private final OperationAuditPort audit; public CreateCartService(CartRepositoryPort c,OperationAuditPort a){carts=c;audit=a;}
 public Cart createCart(User actor,Customer customer,String cartId){ServiceSupport.sameCustomer(actor,customer);if(carts.findActiveByCustomer(customer).isPresent())throw new ConflictException("Customer already has an active cart");Cart saved=carts.save(new Cart(cartId,customer));audit.record(actor,"CREATE_CART",saved.getId(),Map.of("customerId",customer.getId()));return saved;}
}
