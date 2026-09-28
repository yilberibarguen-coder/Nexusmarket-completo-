package application.adapters.persistence.mongodb.documents;
import java.time.Instant;
public record AuditLogDocument(String id,String operationId,String actorId,String detail,Instant timestamp) {}
