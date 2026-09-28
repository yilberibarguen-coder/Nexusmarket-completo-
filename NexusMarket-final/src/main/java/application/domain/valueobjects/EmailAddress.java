package application.domain.valueobjects;
import java.util.regex.Pattern;
public record EmailAddress(String value) {
    private static final Pattern PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    public EmailAddress { if (value == null || !PATTERN.matcher(value).matches()) throw new IllegalArgumentException("Invalid email address"); }
    @Override public String toString() { return value; }
}
