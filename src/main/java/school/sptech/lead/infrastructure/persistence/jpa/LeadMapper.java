package school.sptech.lead.infrastructure.persistence.jpa;

import school.sptech.lead.core.domain.lead.Lead;

public class LeadMapper {

    private LeadMapper() {

    }

    public static LeadEntity toEntity(Lead lead) {
        return new LeadEntity(
                lead.getId().getValue(),
                lead.getCpf().getValue(),
                lead.getNome(),
                lead.getContato().getEmail().getValue(),
                lead.getContato().getTelefone().getValue(),
                lead.getGastoMensal().getValue(),
                lead.getGastoMensal().getClassificacao().name(),
                lead.getGastoMensal().getClassificacao().getDescricao()
        );
    }

    public static Lead toDomain(LeadEntity entity) {
        return Lead.existente(
                entity.id().toString(),
                entity.cpf(),
                entity.nome(),
                entity.email(),
                entity.telefone(),
                entity.consumo()
        );
    }
}
