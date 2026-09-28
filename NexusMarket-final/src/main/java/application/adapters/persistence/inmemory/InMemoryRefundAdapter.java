package application.adapters.persistence.inmemory;
import application.domain.model.*; import application.domain.ports.out.RefundRepositoryPort; import java.util.*; import java.util.concurrent.ConcurrentHashMap;
public class InMemoryRefundAdapter implements RefundRepositoryPort {private final Map<String,Refund> data=new ConcurrentHashMap<>();public Refund save(Refund r){data.put(r.id(),r);return r;}public Optional<Refund> findById(String id){return Optional.ofNullable(data.get(id));}}
