package application.domain.services.authentication;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport; import java.util.*;
public class ChangeUserStatusService implements ChangeUserStatusUseCase { private final UserRepositoryPort users; private final OperationAuditPort audit; public ChangeUserStatusService(UserRepositoryPort u,OperationAuditPort a){users=u;audit=a;}
 public User changeUserStatus(User actor,String id,application.domain.enums.UserStatus status){ServiceSupport.role(actor,"ADMIN");User u=ServiceSupport.required(users.findById(id),"User",id);u.changeStatus(status);users.update(u);audit.record(actor,"CHANGE_USER_STATUS",id,Map.of("status",status.name()));return u;}
}
