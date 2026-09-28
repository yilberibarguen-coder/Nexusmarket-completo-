package application.domain.model;
import java.math.*; import java.time.*;
public record Promotion(String id,String name,BigDecimal percentage,LocalDate start,LocalDate end) { public boolean active(LocalDate d){return !d.isBefore(start)&&!d.isAfter(end);} }
