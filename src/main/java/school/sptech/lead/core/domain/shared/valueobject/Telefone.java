package school.sptech.lead.core.domain.shared.valueobject;

import school.sptech.lead.core.domain.shared.exception.ArgumentoInvalidoException;

import java.util.regex.Pattern;

public class Telefone {
    private String value;

    private static final Pattern TELEFONE =
            Pattern.compile("^\\(?\\d{2}\\)?\\s?(?:9\\d{4}|\\d{4})-?\\d{4}$");


    private Telefone(String value) {
        this.value = value;
    }

    public static Telefone of(String value) {
        boolean matches = value.matches(TELEFONE.pattern());
        if (matches) {
            return new Telefone(value);
        }
        throw new ArgumentoInvalidoException("Formato de telefone inválido");
    }

    public String getValue() {
        return value;
    }
}
