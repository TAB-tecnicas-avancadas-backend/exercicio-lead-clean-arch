package school.sptech.lead.core.application.usecase.lead;

import school.sptech.lead.core.adapters.lead.LeadMutation;
import school.sptech.lead.core.application.usecase.command.CriarLeadCommand;
import school.sptech.lead.core.domain.lead.Lead;

public class RegistrarLeadUseCase {

    private final LeadMutation mutationService;

    public RegistrarLeadUseCase(LeadMutation mutationService) {
        this.mutationService = mutationService;
    }

    public Lead executar(CriarLeadCommand command) {

        Lead novoLead = Lead.novo(
                command.cpf(),
                command.nome(),
                command.email(),
                command.telefone(),
                command.consumoMedio()
        );

        return mutationService.save(novoLead);
    }
}
