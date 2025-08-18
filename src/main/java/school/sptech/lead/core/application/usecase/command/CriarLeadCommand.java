package school.sptech.lead.core.application.usecase.command;

public record CriarLeadCommand(
        String cpf,
        String nome,
        String email,
        String telefone,
        double consumoMedio
) {}
