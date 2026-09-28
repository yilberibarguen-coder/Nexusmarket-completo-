package application.domain.model;
import application.domain.enums.UserRole;
public abstract class Employee extends Person {
    protected final UserRole role;
    protected Employee(String id,String name,String email,String phone,UserRole role){super(id,name,email,phone);if(role==null)throw new IllegalArgumentException("Role is required");this.role=role;}
    public UserRole getRole(){return role;}
}
