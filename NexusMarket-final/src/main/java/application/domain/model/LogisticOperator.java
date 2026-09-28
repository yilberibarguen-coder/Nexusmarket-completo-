package application.domain.model;
import application.domain.enums.UserRole;
public class LogisticOperator extends Employee {
    public LogisticOperator(String id,String name,String email,String phone){super(id,name,email,phone,UserRole.LOGISTIC_OPERATOR);}
}
