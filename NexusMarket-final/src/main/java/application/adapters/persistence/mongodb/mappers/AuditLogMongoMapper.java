package application.adapters.persistence.mongodb.mappers;
import application.adapters.persistence.mongodb.documents.AuditLogDocument;
import application.domain.model.AuditLog;
public final class AuditLogMongoMapper { private AuditLogMongoMapper(){} public static AuditLogDocument toDocument(AuditLog a){return new AuditLogDocument(a.id(),a.operationId(),a.actorId(),a.detail(),a.timestamp());} }
