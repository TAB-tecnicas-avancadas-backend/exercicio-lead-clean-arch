package school.sptech.lead.infrastructure.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "lead")
public class LeadEntity {

    @Id
    private UUID id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private double consumo;
    private String prioridade;
    private String acaoPrioridade;

    public LeadEntity() {
    }

    public LeadEntity(UUID id, String cpf, String nome, String email, String telefone, double consumo, String prioridade, String acaoPrioridade) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.consumo = consumo;
        this.prioridade = prioridade;
        this.acaoPrioridade = acaoPrioridade;
    }

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String cpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String nome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String telefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double consumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public String prioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String acaoPrioridade() {
        return acaoPrioridade;
    }

    public void setAcaoPrioridade(String acaoPrioridade) {
        this.acaoPrioridade = acaoPrioridade;
    }
}
