package school.sptech.lead.core.application.usecase.lead;

import school.sptech.lead.core.adapters.lead.LeadQuery;
import school.sptech.lead.core.domain.lead.Lead;

import java.util.List;

public class ListarLeadUseCase {

    private final LeadQuery queryService;

    public ListarLeadUseCase(LeadQuery queryService) {
        this.queryService = queryService;
    }

    public List<Lead> executar() {
        return queryService.findAll();
    }
}
