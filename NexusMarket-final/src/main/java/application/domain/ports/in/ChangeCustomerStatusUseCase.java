package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ChangeCustomerStatusUseCase {
        Customer changeStatus(User actor, String customerId, DomainTypes.Status status);
    }
