package school.sptech.lead.infrastructure.persistence.jpa;

import org.springframework.stereotype.Repository;
import school.sptech.lead.core.adapters.lead.LeadMutation;
import school.sptech.lead.core.adapters.lead.LeadQuery;
import school.sptech.lead.core.domain.lead.Lead;
import school.sptech.lead.core.domain.lead.valueobject.LeadId;

import java.util.List;
import java.util.Optional;

@Repository
public class LeadJpaAdapter implements LeadQuery, LeadMutation {

    private final LeadJpaRepository repository;

    public LeadJpaAdapter(LeadJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lead save(Lead lead) {
        LeadEntity toSave = LeadMapper.toEntity(lead);
        LeadEntity saved = repository.save(toSave);
        return LeadMapper.toDomain(saved);
    }

    @Override
    public List<Lead> findAll() {
        return repository.findAll()
                .stream().map(LeadMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Lead> findById(LeadId id) {
        return repository.findById(id.getValue())
                .map(LeadMapper::toDomain);
    }
}
