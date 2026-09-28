package application.domain.services.customer;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class ManageCustomerAddressesService implements ManageCustomerAddressesUseCase {
 private final CustomerRepositoryPort customers; private final OperationAuditPort audit;
 public ManageCustomerAddressesService(CustomerRepositoryPort c,OperationAuditPort a){customers=c;audit=a;}
 public Customer manageAddresses(User actor,String id,Address address,String operation){Customer c=ServiceSupport.required(customers.findById(id),"Customer",id); ServiceSupport.sameCustomer(actor,c); if(operation==null)throw new DomainRuleException("Address operation is required"); switch(operation.toUpperCase()){case "ADD"->c.addAddress(address);case "UPDATE"->c.updateAddress(address);case "REMOVE"->c.removeAddress(address.id());default->throw new DomainRuleException("Unsupported address operation: "+operation);} customers.update(c); audit.record(actor,"MANAGE_CUSTOMER_ADDRESSES",id,Map.of("operation",operation)); return c;}
}
