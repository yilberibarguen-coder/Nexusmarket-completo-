package application.domain.services.cart;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class RemoveProductFromCartService implements RemoveProductFromCartUseCase { private final CartRepositoryPort carts; private final CustomerRepositoryPort customers; private final OperationAuditPort audit; public RemoveProductFromCartService(CartRepositoryPort c,CustomerRepositoryPort cu,OperationAuditPort a){carts=c;customers=cu;audit=a;}
 public Cart removeProduct(User actor,String cid,String pid){Customer c=ServiceSupport.required(customers.findById(cid),"Customer",cid);ServiceSupport.sameCustomer(actor,c);Cart cart=ServiceSupport.required(carts.findActiveByCustomer(c),"Cart",cid);cart.remove(pid);carts.update(cart);audit.record(actor,"REMOVE_PRODUCT_FROM_CART",cart.getId(),Map.of("productId",pid));return cart;}
}
