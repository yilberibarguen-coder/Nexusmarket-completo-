package application.domain.model;
import java.math.*;
public record Refund(String id,ReturnRequest request,BigDecimal amount) {}
