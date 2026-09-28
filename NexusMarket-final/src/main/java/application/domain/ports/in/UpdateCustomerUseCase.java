package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface UpdateCustomerUseCase {
        Customer update(User actor, Customer customer);
    }
