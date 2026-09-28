package application.domain.enums;
public enum UserRole {
    BUYER, SELLER, LOGISTIC_OPERATOR, ADMIN, SUPERVISOR, SUPPORT_AGENT, EMPLOYEE;
    public static UserRole fromLegacy(String value) {
        if(value==null||value.isBlank()) throw new IllegalArgumentException("Role is required");
        return switch(value.trim().toUpperCase()) {
            case "CUSTOMER", "BUYER", "NATURAL_CUSTOMER", "BUSINESS_CUSTOMER" -> BUYER;
            case "SELLER" -> SELLER;
            case "LOGISTIC_OPERATOR", "LOGISTICS", "LOGISTIC" -> LOGISTIC_OPERATOR;
            case "ADMIN", "ADMINISTRATOR" -> ADMIN;
            case "SUPERVISOR" -> SUPERVISOR;
            case "SUPPORT_AGENT", "SUPPORT" -> SUPPORT_AGENT;
            case "EMPLOYEE", "TELLER", "COMMERCIAL_EMPLOYEE", "INTERNAL_ANALYST" -> EMPLOYEE;
            default -> throw new IllegalArgumentException("Unsupported role: " + value);
        };
    }
}
