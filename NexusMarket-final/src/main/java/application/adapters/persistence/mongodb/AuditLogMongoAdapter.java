package application.adapters.persistence.mongodb;
import application.adapters.persistence.mongodb.mappers.AuditLogMongoMapper;
import application.adapters.persistence.mongodb.repositories.AuditLogMongoRepository;
import application.domain.model.*; import application.domain.ports.out.AuditLogRepositoryPort; import java.util.*;
/** NoSQL audit output boundary. The repository can be replaced by Spring Data MongoRepository. */
public final class AuditLogMongoAdapter implements AuditLogRepositoryPort { private final AuditLogMongoRepository repository; public AuditLogMongoAdapter(AuditLogMongoRepository repository){this.repository=repository;} public AuditLog save(AuditLog a){repository.save(AuditLogMongoMapper.toDocument(a));return a;} public List<AuditLog> findAll(){return repository.findAll().stream().map(d->new AuditLog(d.id(),d.operationId(),d.actorId(),d.detail(),d.timestamp())).toList();} }
