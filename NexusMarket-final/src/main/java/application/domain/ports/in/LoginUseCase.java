package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface LoginUseCase {
        String login(String username, String password);
    }
