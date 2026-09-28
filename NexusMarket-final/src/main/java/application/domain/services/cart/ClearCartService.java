package application.domain.services.cart;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ClearCartService implements ClearCartUseCase { private final CartRepositoryPort carts; private final CustomerRepositoryPort customers; private final OperationAuditPort audit; public ClearCartService(CartRepositoryPort c,CustomerRepositoryPort cu,OperationAuditPort a){carts=c;customers=cu;audit=a;}
 public Cart clearCart(User actor,String cid){Customer c=ServiceSupport.required(customers.findById(cid),"Customer",cid);ServiceSupport.sameCustomer(actor,c);Cart cart=ServiceSupport.required(carts.findActiveByCustomer(c),"Cart",cid);cart.clear();carts.update(cart);audit.record(actor,"CLEAR_CART",cart.getId(),Map.of());return cart;}
}
