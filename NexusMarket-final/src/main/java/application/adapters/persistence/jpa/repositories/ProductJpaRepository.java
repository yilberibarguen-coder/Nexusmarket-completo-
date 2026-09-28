package application.adapters.persistence.jpa.repositories;
import application.adapters.persistence.jpa.entities.ProductJpaEntity;
import java.util.*;
public interface ProductJpaRepository { ProductJpaEntity save(ProductJpaEntity entity); Optional<ProductJpaEntity> findById(String id); List<ProductJpaEntity> findAll(); }
