package school.sptech.lead.core.adapters.lead;

import school.sptech.lead.core.domain.lead.Lead;
import school.sptech.lead.core.domain.lead.valueobject.LeadId;

import java.util.List;
import java.util.Optional;

public interface LeadQuery {
    List<Lead> findAll();
    Optional<Lead> findById(LeadId id);
}
