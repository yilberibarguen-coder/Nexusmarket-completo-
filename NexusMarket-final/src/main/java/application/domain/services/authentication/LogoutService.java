package application.domain.services.authentication;
import application.domain.ports.in.*; import application.domain.ports.out.*;
public class LogoutService implements LogoutUseCase { private final TokenServicePort tokens; public LogoutService(TokenServicePort t){tokens=t;} public void logout(String token){if(token==null||token.isBlank())throw new IllegalArgumentException("Token is required");tokens.invalidate(token);} }
