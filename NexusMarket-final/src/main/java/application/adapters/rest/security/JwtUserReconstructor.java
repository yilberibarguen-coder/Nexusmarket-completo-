package application.adapters.rest.security;
import application.adapters.security.JwtTokenAdapter;
import application.domain.enums.UserRole;
import application.domain.model.User;
/** Reconstructs the minimum authenticated User aggregate from a verified JWT subject. */
public final class JwtUserReconstructor {
    private final JwtTokenAdapter tokens;
    public JwtUserReconstructor(JwtTokenAdapter tokens){this.tokens=tokens;}
    public User reconstruct(String token){String id=tokens.userId(token); UserRole role=UserRole.valueOf(tokens.role(token)); return new User(id,id,"JWT_AUTHENTICATED",role);}
}
