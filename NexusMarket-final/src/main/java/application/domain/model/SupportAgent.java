package application.domain.model;
import application.domain.enums.UserRole;
public class SupportAgent extends Employee {
    public SupportAgent(String id,String name,String email,String phone){super(id,name,email,phone,UserRole.SUPPORT_AGENT);}
}
