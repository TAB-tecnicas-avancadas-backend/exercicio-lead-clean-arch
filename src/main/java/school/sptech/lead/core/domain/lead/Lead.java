package school.sptech.lead.core.domain.lead;

import school.sptech.lead.core.domain.lead.valueobject.Contato;
import school.sptech.lead.core.domain.lead.valueobject.GastoMensal;
import school.sptech.lead.core.domain.lead.valueobject.LeadId;
import school.sptech.lead.core.domain.shared.valueobject.Cpf;
import school.sptech.lead.core.domain.shared.valueobject.Email;
import school.sptech.lead.core.domain.shared.valueobject.Telefone;

public class Lead {

    private LeadId id;
    private Cpf cpf;
    private String nome;
    private Contato contato;
    private GastoMensal gastoMensal;

    private Lead(
            LeadId id,
            Cpf cpf,
            String nome,
            Contato contato,
            GastoMensal gastoMensal
    ) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
        this.gastoMensal = gastoMensal;
    }

    public static Lead novo(
            String cpf,
            String nome,
            String email,
            String telefone,
            double gastoMensal
    ) {
        return new Lead(
                LeadId.novo(),
                Cpf.of(cpf),
                nome,
                Contato.of(email, telefone),
                GastoMensal.of(gastoMensal)
        );
    }

    public static Lead existente(
            String id,
            String cpf,
            String nome,
            String email,
            String telefone,
            double gastoMensal
    ) {
        return new Lead(
                LeadId.existente(id),
                Cpf.of(cpf),
                nome,
                Contato.of(email, telefone),
                GastoMensal.of(gastoMensal)
        );
    }

    public LeadId getId() {
        return id;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Contato getContato() {
        return contato;
    }

    public GastoMensal getGastoMensal() {
        return gastoMensal;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", contato=" + contato +
                ", gastoMensal=" + gastoMensal +
                '}';
    }
}
