package application.domain.services.customer;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class UpdateCustomerService implements UpdateCustomerUseCase {
 private final CustomerRepositoryPort customers; private final OperationAuditPort audit;
 public UpdateCustomerService(CustomerRepositoryPort c,OperationAuditPort a){customers=c;audit=a;}
 public Customer update(User actor,Customer c){ServiceSupport.actor(actor); Customer stored=ServiceSupport.required(customers.findById(c.getId()),"Customer",c.getId()); ServiceSupport.sameCustomer(actor,stored); if(!stored.getEmail().equals(c.getEmail())) customers.findByEmail(c.getEmail()).ifPresent(x->{if(!x.getId().equals(c.getId()))throw new ConflictException("Email already exists");}); stored.update(c.getName(),c.getEmail(),c.getPhone()); customers.update(stored); audit.record(actor,"UPDATE_CUSTOMER",stored.getId(),Map.of()); return stored;}
}
