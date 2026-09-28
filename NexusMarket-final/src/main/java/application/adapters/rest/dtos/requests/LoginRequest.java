package application.adapters.rest.dtos.requests;
public record LoginRequest(String username,String password) { public LoginRequest { if(username==null||username.isBlank()||password==null||password.isBlank()) throw new IllegalArgumentException("Username and password are required"); } }
