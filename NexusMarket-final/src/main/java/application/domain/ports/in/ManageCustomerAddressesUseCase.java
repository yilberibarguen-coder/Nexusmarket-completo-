package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ManageCustomerAddressesUseCase {
        Customer manageAddresses(User actor, String customerId, Address address, String operation);
    }
