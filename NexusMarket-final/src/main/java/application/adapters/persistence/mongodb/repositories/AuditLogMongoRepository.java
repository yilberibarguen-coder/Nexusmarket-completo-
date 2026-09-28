package application.adapters.persistence.mongodb.repositories;
import application.adapters.persistence.mongodb.documents.AuditLogDocument;
import java.util.*;
public interface AuditLogMongoRepository { AuditLogDocument save(AuditLogDocument d); List<AuditLogDocument> findAll(); }
