package school.sptech.lead.core.domain.shared.valueobject;

import school.sptech.lead.core.domain.shared.exception.ArgumentoInvalidoException;

import java.util.regex.Pattern;

public class Email {
    private String value;
    private static Pattern EMAIL = Pattern
            .compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private Email(String value) {
        this.value = value;
    }

    public static Email of(String value) {
        boolean matches = value.matches(EMAIL.pattern());
        if (matches) {
            return new Email(value);
        }
        throw new ArgumentoInvalidoException("Formato de email inválido");
    }

    public String getValue() {
        return value;
    }
}
