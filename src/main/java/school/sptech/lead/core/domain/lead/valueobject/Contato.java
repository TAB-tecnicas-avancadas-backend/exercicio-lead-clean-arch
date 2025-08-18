package school.sptech.lead.core.domain.lead.valueobject;

import school.sptech.lead.core.domain.shared.valueobject.Email;
import school.sptech.lead.core.domain.shared.valueobject.Telefone;

public class Contato {
    private Email email;
    private Telefone telefone;

    private Contato(Email email, Telefone telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public static Contato of(String email, String telefone) {
        return new Contato(
                Email.of(email),
                Telefone.of(telefone)
        );
    }

    public Email getEmail() {
        return email;
    }

    public Telefone getTelefone() {
        return telefone;
    }
}
