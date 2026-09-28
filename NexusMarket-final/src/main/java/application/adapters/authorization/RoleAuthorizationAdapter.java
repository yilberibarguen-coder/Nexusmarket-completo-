package application.adapters.authorization;
import application.domain.model.User; import application.domain.ports.out.AuthorizationPort;
public class RoleAuthorizationAdapter implements AuthorizationPort {
 private boolean role(User u,String... roles){if(u==null)return false;for(String r:roles)if(r.equalsIgnoreCase(u.getRole().name()))return true;return false;}
 public boolean canManageCustomers(User u){return role(u,"ADMIN","EMPLOYEE");} public boolean canManageCatalog(User u){return role(u,"ADMIN","SELLER");}
 public boolean canManageInventory(User u){return role(u,"ADMIN","SELLER");} public boolean canManageOrders(User u){return role(u,"ADMIN","EMPLOYEE","SELLER");}
}
