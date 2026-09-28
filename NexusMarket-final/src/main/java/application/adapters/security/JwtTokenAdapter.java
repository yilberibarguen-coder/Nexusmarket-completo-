package application.adapters.security;

import application.domain.model.User;
import application.domain.ports.out.TokenServicePort;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Minimal JWT-compatible HS256 token adapter with no external dependency. */
public final class JwtTokenAdapter implements TokenServicePort {
    private final String secret;
    private final Map<String,String> activeTokens = new ConcurrentHashMap<>();
    public JwtTokenAdapter(String secret) { if(secret==null||secret.length()<16) throw new IllegalArgumentException("JWT secret must have at least 16 characters"); this.secret=secret; }
    @Override public String generate(User user) {
        long now=System.currentTimeMillis()/1000; long exp=now+3600;
        String header=encode("{\"alg\":\"HS256\",\"typ\":\"JWT\"}");
        String payload=encode("{\"sub\":\""+escape(user.getId())+"\",\"username\":\""+escape(user.getUsername())+"\",\"role\":\""+user.getRole().name()+"\",\"iat\":"+now+",\"exp\":"+exp+"}");
        String unsigned=header+"."+payload; String token=unsigned+"."+sign(unsigned); activeTokens.put(token,user.getId()); return token;
    }
    @Override public void invalidate(String token){activeTokens.remove(token);}
    public boolean isActive(String token){return activeTokens.containsKey(token)&&verify(token);}
    public String userId(String token){return claim(token,"sub");}
    public String role(String token){return claim(token,"role");}
    private String claim(String token,String name){if(!isActive(token))throw new IllegalArgumentException("Invalid token"); String payload=new String(Base64.getUrlDecoder().decode(token.split("\\.")[1]),StandardCharsets.UTF_8); String marker="\""+name+"\":\""; int i=payload.indexOf(marker); if(i<0)throw new IllegalArgumentException("Missing claim: "+name); i+=marker.length(); int j=payload.indexOf('"',i); return payload.substring(i,j);}
    private boolean verify(String token){String[] p=token.split("\\.");return p.length==3&&MessageDigest.isEqual(sign((p[0]+"."+p[1])).getBytes(StandardCharsets.UTF_8),p[2].getBytes(StandardCharsets.UTF_8));}
    private String sign(String value){try{var mac=javax.crypto.Mac.getInstance("HmacSHA256");mac.init(new javax.crypto.spec.SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),"HmacSHA256"));return Base64.getUrlEncoder().withoutPadding().encodeToString(mac.doFinal(value.getBytes(StandardCharsets.UTF_8)));}catch(Exception e){throw new IllegalStateException(e);}}
    private static String encode(String value){return Base64.getUrlEncoder().withoutPadding().encodeToString(value.getBytes(StandardCharsets.UTF_8));}
    private static String escape(String value){return value.replace("\\","\\\\").replace("\"","\\\"");}
}
