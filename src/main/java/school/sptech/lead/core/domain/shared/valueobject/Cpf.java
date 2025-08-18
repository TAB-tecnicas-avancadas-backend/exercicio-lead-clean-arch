package school.sptech.lead.core.domain.shared.valueobject;

import school.sptech.lead.core.domain.shared.exception.ArgumentoInvalidoException;

import java.util.regex.Pattern;

public class Cpf {

    private String value;
    private static Pattern CPF = Pattern.compile("^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}");

    private Cpf(String value) {
        this.value = value;
    }

    public static Cpf of(String numero) {
        boolean matches = numero.matches(CPF.pattern());
        if (matches) {
            return new Cpf(numero);
        }
        throw new ArgumentoInvalidoException("Formato de CPF desconhecido");
    }

    public String getValue() {
        return value;
    }
}
