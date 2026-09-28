package application.domain.ports.in;
    import application.domain.model.*;
import java.math.BigDecimal;
import java.util.List;
    public interface ApproveReturnUseCase {
        ReturnRequest approveReturn(User actor, String returnId, boolean approve);
    }
