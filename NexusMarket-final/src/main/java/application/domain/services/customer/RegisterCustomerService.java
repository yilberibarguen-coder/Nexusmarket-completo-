package application.domain.services.customer;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.exceptions.*;
import application.domain.services.ServiceSupport; import java.util.*;
public class RegisterCustomerService implements RegisterCustomerUseCase {
 private final CustomerRepositoryPort customers; private final OperationAuditPort audit; private final AuthorizationPort auth;
 public RegisterCustomerService(CustomerRepositoryPort customers,OperationAuditPort audit,AuthorizationPort auth){this.customers=customers;this.audit=audit;this.auth=auth;}
 public Customer register(User actor,Customer c){ if(c==null)throw new DomainRuleException("Customer is required"); if(actor!=null)ServiceSupport.actor(actor); if(customers.findById(c.getId()).isPresent()||customers.findByEmail(c.getEmail()).isPresent())throw new ConflictException("Customer identification or email already exists"); Customer saved=customers.save(c); if(actor!=null)audit.record(actor,"REGISTER_CUSTOMER",saved.getId(),Map.of("email",saved.getEmail())); return saved;}
}
