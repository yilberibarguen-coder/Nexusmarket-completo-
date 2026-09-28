package application.domain.services;
import application.domain.exceptions.*; import application.domain.model.*;
import application.domain.ports.out.*;
public final class ServiceSupport {
    private ServiceSupport(){}
    public static void actor(User u){ if(u==null) throw new UnauthorizedException("Actor is required"); if(u.getStatus()!=application.domain.enums.UserStatus.ACTIVE) throw new UnauthorizedException("Actor is not active");}
    public static void role(User u,String... roles){actor(u); for(String r:roles) if(r.equalsIgnoreCase(u.getRole().name())) return; throw new UnauthorizedException("Actor lacks required role");}
    public static void sameCustomer(User actor,Customer c){actor(actor); if(actor.getCustomer()!=null && !actor.getCustomer().getId().equals(c.getId()) && !"ADMIN".equalsIgnoreCase(actor.getRole().name()) && !"EMPLOYEE".equalsIgnoreCase(actor.getRole().name())) throw new UnauthorizedException("Actor cannot access this customer");}
    public static <T> T required(java.util.Optional<T> v,String type,String id){return v.orElseThrow(()->new NotFoundException(type,id));}
}
