package application.domain.services.authentication;
import application.domain.model.*; import application.domain.ports.in.*; import application.domain.ports.out.*; import application.domain.services.ServiceSupport;
public class ConsultUserService implements ConsultUserUseCase { private final UserRepositoryPort users; public ConsultUserService(UserRepositoryPort u){users=u;}
 public User consultUser(User actor,String id){ServiceSupport.actor(actor);User target=ServiceSupport.required(users.findById(id),"User",id);if(!actor.getId().equals(id)&&!"ADMIN".equalsIgnoreCase(actor.getRole().name())&&!"EMPLOYEE".equalsIgnoreCase(actor.getRole().name()))throw new application.domain.exceptions.UnauthorizedException("Cannot consult this user");return target;}
}
