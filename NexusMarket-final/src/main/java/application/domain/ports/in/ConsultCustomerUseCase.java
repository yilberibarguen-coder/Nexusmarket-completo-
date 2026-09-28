package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ConsultCustomerUseCase {
        Customer consult(User actor, String customerId);
    }
