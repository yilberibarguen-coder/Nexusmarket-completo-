package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface RegisterCustomerUseCase {
        Customer register(User actor, Customer customer);
    }
