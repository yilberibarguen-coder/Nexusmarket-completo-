package application.domain.services.authentication;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class RegisterCustomerUserService implements RegisterCustomerUserUseCase {
 private final UserRepositoryPort users; private final CustomerRepositoryPort customers; private final PasswordServicePort passwords; private final OperationAuditPort audit;
 public RegisterCustomerUserService(UserRepositoryPort u,CustomerRepositoryPort c,PasswordServicePort p,OperationAuditPort a){users=u;customers=c;passwords=p;audit=a;}
 public User registerCustomerUser(User actor,Customer customer,User user){if(actor!=null)ServiceSupport.role(actor,"ADMIN","EMPLOYEE");Customer stored=ServiceSupport.required(customers.findById(customer.getId()),"Customer",customer.getId());if(users.findByUsername(user.getUsername()).isPresent())throw new ConflictException("Username already exists");user.changePasswordHash(passwords.hash(user.getPasswordHash()));user.linkCustomer(stored);User saved=users.save(user);if(actor!=null)audit.record(actor,"REGISTER_CUSTOMER_USER",saved.getId(),Map.of("customerId",stored.getId()));return saved;}
}
