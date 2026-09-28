package application.domain.model;
import java.time.*;
public record Operation(String id,String type,String actorId,String aggregateId,Instant timestamp) {}
