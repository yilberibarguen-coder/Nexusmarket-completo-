package application.domain.model;

import application.domain.enums.UserRole;

public class User {
    private final String id;
    private final String username;
    private String passwordHash;
    private UserRole role;
    private application.domain.enums.UserStatus status=application.domain.enums.UserStatus.ACTIVE;
    private Customer customer;
    public User(String id,String username,String passwordHash,UserRole role){
        if(id==null||id.isBlank()||username==null||username.isBlank()||passwordHash==null||role==null) throw new IllegalArgumentException("Invalid user");
        this.id=id;this.username=username;this.passwordHash=passwordHash;this.role=role;
    }
    public User(String id,String username,String passwordHash,String role){this(id,username,passwordHash,UserRole.fromLegacy(role));}
    public String getId(){return id;} public String getUsername(){return username;} public String getPasswordHash(){return passwordHash;}
    public boolean passwordMatches(String hash){return passwordHash.equals(hash);} public void changePasswordHash(String hash){if(hash==null||hash.isBlank())throw new IllegalArgumentException("Password hash is required");this.passwordHash=hash;}
    public void changeStatus(application.domain.enums.UserStatus s){if(s==null)throw new IllegalArgumentException("Status is required");status=s;} public application.domain.enums.UserStatus getStatus(){return status;}
    public UserRole getRole(){return role;} public void changeRole(UserRole role){if(role==null)throw new IllegalArgumentException("Role is required");this.role=role;}
    public Customer getCustomer(){return customer;} public void linkCustomer(Customer customer){this.customer=customer;}
}
