package application.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

public final class DomainTypes {
    private DomainTypes() {}
    public enum Status { ACTIVE, INACTIVE, BLOCKED }
    public enum ProductStatus { ACTIVE, INACTIVE, BLOCKED }
    public enum OrderStatus { CREATED, PENDING_PAYMENT, PAID, PROCESSING, SHIPPED, DELIVERED, CANCELLED, RETURN_REQUESTED, RETURNED, REFUNDED }
    public enum PaymentStatus { PENDING, APPROVED, DECLINED, REFUNDED }
    public enum ShipmentStatus { CREATED, IN_TRANSIT, DELIVERED, RETURNED }
}
