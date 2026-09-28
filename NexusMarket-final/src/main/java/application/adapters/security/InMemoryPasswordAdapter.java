package application.adapters.security;
import application.domain.ports.out.PasswordServicePort; import java.nio.charset.StandardCharsets; import java.security.MessageDigest;
public class InMemoryPasswordAdapter implements PasswordServicePort {
 public String hash(String raw){try{return java.util.HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(raw.getBytes(StandardCharsets.UTF_8)));}catch(Exception e){throw new IllegalStateException(e);}}
 public boolean matches(String raw,String hash){return hash(raw).equals(hash);}
}
