package application.domain.model;
import application.domain.enums.UserRole;
public class Supervisor extends Employee {
    public Supervisor(String id,String name,String email,String phone){super(id,name,email,phone,UserRole.SUPERVISOR);}
}
