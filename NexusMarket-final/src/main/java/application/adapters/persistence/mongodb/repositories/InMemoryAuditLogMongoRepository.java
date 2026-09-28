package application.adapters.persistence.mongodb.repositories;
import application.adapters.persistence.mongodb.documents.AuditLogDocument;
import java.util.*; import java.util.concurrent.CopyOnWriteArrayList;
public final class InMemoryAuditLogMongoRepository implements AuditLogMongoRepository { private final List<AuditLogDocument> data=new CopyOnWriteArrayList<>(); public AuditLogDocument save(AuditLogDocument d){data.add(d);return d;} public List<AuditLogDocument> findAll(){return List.copyOf(data);} }
