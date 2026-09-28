package application.adapters.persistence.inmemory;
import application.domain.model.*; import application.domain.ports.out.WishlistRepositoryPort; import java.util.*; import java.util.concurrent.ConcurrentHashMap;
public class InMemoryWishlistAdapter implements WishlistRepositoryPort {private final Map<String,Wishlist> data=new ConcurrentHashMap<>();public Wishlist save(Wishlist w){data.put(w.getOwner().getId(),w);return w;}public Optional<Wishlist> findByCustomer(Customer c){return Optional.ofNullable(data.get(c.getId()));}public void update(Wishlist w){data.put(w.getOwner().getId(),w);}}
