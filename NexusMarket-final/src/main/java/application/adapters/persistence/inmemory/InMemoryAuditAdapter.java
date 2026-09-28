package application.adapters.persistence.inmemory;
import application.domain.model.*; import application.domain.ports.out.*; import java.time.*; import java.util.*; import java.util.concurrent.CopyOnWriteArrayList;
public class InMemoryAuditAdapter implements AuditLogRepositoryPort,OperationAuditPort {
 private final List<AuditLog> logs=new CopyOnWriteArrayList<>();
 public AuditLog save(AuditLog l){logs.add(l);return l;} public List<AuditLog> findAll(){return List.copyOf(logs);}
 public void record(User actor,String type,String aggregateId,Map<String,Object> details){save(new AuditLog(UUID.randomUUID().toString(),type,actor==null?null:actor.getId(),String.valueOf(details),Instant.now()));}
}
