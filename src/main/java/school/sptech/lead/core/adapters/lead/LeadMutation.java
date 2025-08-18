package school.sptech.lead.core.adapters.lead;

import school.sptech.lead.core.domain.lead.Lead;

public interface LeadMutation {
    Lead save(Lead lead);
}
