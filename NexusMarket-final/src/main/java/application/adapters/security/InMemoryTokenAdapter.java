package application.adapters.security;
import application.domain.model.User; import application.domain.ports.out.TokenServicePort; import java.util.*; import java.util.concurrent.ConcurrentHashMap;
public class InMemoryTokenAdapter implements TokenServicePort {private final Map<String,String> active=new ConcurrentHashMap<>();public String generate(User u){String t=UUID.randomUUID().toString();active.put(t,u.getId());return t;}public void invalidate(String token){active.remove(token);}public boolean isValid(String token){return active.containsKey(token);}}
