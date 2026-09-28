package application.domain.services.authentication;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import application.domain.exceptions.*; import java.util.*;
public class RegisterEmployeeUserService implements RegisterEmployeeUserUseCase {
 private final UserRepositoryPort users; private final PasswordServicePort passwords; private final OperationAuditPort audit;
 public RegisterEmployeeUserService(UserRepositoryPort u,PasswordServicePort p,OperationAuditPort a){users=u;passwords=p;audit=a;}
 public User registerEmployeeUser(User actor,User user){ServiceSupport.role(actor,"ADMIN");if(users.findByUsername(user.getUsername()).isPresent())throw new ConflictException("Username already exists");user.changePasswordHash(passwords.hash(user.getPasswordHash()));User saved=users.save(user);audit.record(actor,"REGISTER_EMPLOYEE_USER",saved.getId(),Map.of("role",saved.getRole()));return saved;}
}
