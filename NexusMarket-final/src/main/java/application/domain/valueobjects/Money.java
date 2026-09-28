package application.domain.valueobjects;
import java.math.BigDecimal;
import java.util.Objects;
public record Money(BigDecimal amount) {
    public Money { if (amount == null || amount.signum() < 0) throw new IllegalArgumentException("Amount cannot be negative"); amount = amount.setScale(2, java.math.RoundingMode.HALF_UP); }
    public Money add(Money other) { return new Money(amount.add(other.amount)); }
    public Money multiply(int quantity) { return new Money(amount.multiply(BigDecimal.valueOf(quantity))); }
    public int compareTo(Money other) { return amount.compareTo(other.amount); }
    public static Money zero() { return new Money(BigDecimal.ZERO); }
    public BigDecimal value() { return amount; }
}
