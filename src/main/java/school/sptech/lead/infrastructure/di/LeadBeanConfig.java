package school.sptech.lead.infrastructure.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import school.sptech.lead.core.application.usecase.lead.BuscarLeadPorIdUseCase;
import school.sptech.lead.core.application.usecase.lead.ListarLeadUseCase;
import school.sptech.lead.core.application.usecase.lead.RegistrarLeadUseCase;
import school.sptech.lead.infrastructure.persistence.jpa.LeadJpaAdapter;

@Configuration
public class LeadBeanConfig {

    @Bean
    public RegistrarLeadUseCase registrarLeadUseCase(LeadJpaAdapter adapter) {
        return new RegistrarLeadUseCase(adapter);
    }

    @Bean
    public ListarLeadUseCase listarLeadUseCase(LeadJpaAdapter adapter) {
        return new ListarLeadUseCase(adapter);
    }

    @Bean
    public BuscarLeadPorIdUseCase buscarLeadPorIdUseCase(LeadJpaAdapter adapter) {
        return new BuscarLeadPorIdUseCase(adapter);
    }
}
