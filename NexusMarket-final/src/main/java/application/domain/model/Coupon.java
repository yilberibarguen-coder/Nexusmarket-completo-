package application.domain.model;
import java.math.*; import java.time.*;
public record Coupon(String code,BigDecimal discount,LocalDate expiresAt) { public boolean valid(LocalDate date){return date!=null&&!date.isAfter(expiresAt)&&discount.signum()>0;} }
