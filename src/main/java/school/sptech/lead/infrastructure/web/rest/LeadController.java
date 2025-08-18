package school.sptech.lead.infrastructure.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.lead.core.application.usecase.command.CriarLeadCommand;
import school.sptech.lead.core.application.usecase.lead.BuscarLeadPorIdUseCase;
import school.sptech.lead.core.application.usecase.lead.ListarLeadUseCase;
import school.sptech.lead.core.application.usecase.lead.RegistrarLeadUseCase;
import school.sptech.lead.core.domain.lead.Lead;

import java.util.List;

@RestController
@RequestMapping("/v1/leads")
public class LeadController {

    private final ListarLeadUseCase listarLeadUseCase;
    private final RegistrarLeadUseCase registrarLeadUseCase;
    private final BuscarLeadPorIdUseCase buscarLeadPorIdUseCase;

    public LeadController(
            ListarLeadUseCase listarLeadUseCase,
            RegistrarLeadUseCase registrarLeadUseCase,
            BuscarLeadPorIdUseCase buscarLeadPorIdUseCase
    ) {
        this.listarLeadUseCase = listarLeadUseCase;
        this.registrarLeadUseCase = registrarLeadUseCase;
        this.buscarLeadPorIdUseCase = buscarLeadPorIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Lead>> listar() {
        List<Lead> leads = this.listarLeadUseCase.executar();
        if (leads.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(leads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> buscarPorId(@PathVariable String id) {
        Lead lead = this.buscarLeadPorIdUseCase.executar(id);
        return ResponseEntity.ok(lead);
    }

    @PostMapping
    public ResponseEntity<Lead> cadastrar(@RequestBody CriarLeadCommand command) {
        Lead lead = this.registrarLeadUseCase.executar(command);
        return ResponseEntity.status(201).body(lead);
    }
}
