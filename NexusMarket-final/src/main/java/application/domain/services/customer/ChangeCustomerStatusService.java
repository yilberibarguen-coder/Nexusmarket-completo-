package application.domain.services.customer;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ChangeCustomerStatusService implements ChangeCustomerStatusUseCase {
 private final CustomerRepositoryPort customers; private final OperationAuditPort audit; private final AuthorizationPort auth;
 public ChangeCustomerStatusService(CustomerRepositoryPort c,OperationAuditPort a,AuthorizationPort auth){customers=c;audit=a;this.auth=auth;}
 public Customer changeStatus(User actor,String id,DomainTypes.Status status){ServiceSupport.role(actor,"ADMIN","EMPLOYEE"); Customer c=ServiceSupport.required(customers.findById(id),"Customer",id); c.changeStatus(status); customers.update(c); audit.record(actor,"CHANGE_CUSTOMER_STATUS",id,Map.of("status",status.name())); return c;}
}
