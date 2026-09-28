package application.domain.model;
import application.domain.enums.UserRole;
public class Administrator extends Employee {
    public Administrator(String id,String name,String email,String phone){super(id,name,email,phone,UserRole.ADMIN);}
}
