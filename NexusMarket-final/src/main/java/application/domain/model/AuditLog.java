package application.domain.model;
import java.time.*;
public record AuditLog(String id,String operationId,String actorId,String detail,Instant timestamp) {}
