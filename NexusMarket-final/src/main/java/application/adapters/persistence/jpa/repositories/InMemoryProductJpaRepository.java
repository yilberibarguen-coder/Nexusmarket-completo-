package application.adapters.persistence.jpa.repositories;
import application.adapters.persistence.jpa.entities.ProductJpaEntity;
import java.util.*; import java.util.concurrent.ConcurrentHashMap;
public final class InMemoryProductJpaRepository implements ProductJpaRepository { private final Map<String,ProductJpaEntity> data=new ConcurrentHashMap<>(); public ProductJpaEntity save(ProductJpaEntity e){data.put(e.getId(),e);return e;} public Optional<ProductJpaEntity> findById(String id){return Optional.ofNullable(data.get(id));} public List<ProductJpaEntity> findAll(){return List.copyOf(data.values());} }
