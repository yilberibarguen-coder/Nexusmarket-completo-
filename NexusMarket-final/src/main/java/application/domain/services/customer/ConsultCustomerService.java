package application.domain.services.customer;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport;
public class ConsultCustomerService implements ConsultCustomerUseCase {
 private final CustomerRepositoryPort customers; public ConsultCustomerService(CustomerRepositoryPort c){customers=c;}
 public Customer consult(User actor,String id){Customer c=ServiceSupport.required(customers.findById(id),"Customer",id); ServiceSupport.sameCustomer(actor,c); return c;}
}
