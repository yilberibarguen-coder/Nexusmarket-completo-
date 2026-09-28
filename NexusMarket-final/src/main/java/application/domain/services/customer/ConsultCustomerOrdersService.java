package application.domain.services.customer;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ConsultCustomerOrdersService implements ConsultCustomerOrdersUseCase {
 private final CustomerRepositoryPort customers; private final OrderRepositoryPort orders;
 public ConsultCustomerOrdersService(CustomerRepositoryPort c,OrderRepositoryPort o){customers=c;orders=o;}
 public List<Order> consultOrders(User actor,String id){Customer c=ServiceSupport.required(customers.findById(id),"Customer",id);ServiceSupport.sameCustomer(actor,c);return orders.findByCustomer(c);}
}
