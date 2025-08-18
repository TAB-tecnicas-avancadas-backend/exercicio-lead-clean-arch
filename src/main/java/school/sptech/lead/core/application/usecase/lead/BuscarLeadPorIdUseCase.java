package school.sptech.lead.core.application.usecase.lead;

import school.sptech.lead.core.adapters.lead.LeadQuery;
import school.sptech.lead.core.application.usecase.shared.RegistroNaoEncontradoException;
import school.sptech.lead.core.domain.lead.Lead;
import school.sptech.lead.core.domain.lead.valueobject.LeadId;

public class BuscarLeadPorIdUseCase {

    private final LeadQuery queryService;

    public BuscarLeadPorIdUseCase(LeadQuery queryService) {
        this.queryService = queryService;
    }

    public Lead executar(String id) {
        LeadId leadId = LeadId.existente(id);
        return queryService.findById(leadId)
                .orElseThrow(
                        () -> new RegistroNaoEncontradoException("Lead não encontrado")
                );
    }
}
