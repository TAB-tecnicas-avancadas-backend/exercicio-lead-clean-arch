package school.sptech.lead.core.application.usecase.shared;

public class RegistroNaoEncontradoException extends RuntimeException {
    public RegistroNaoEncontradoException(String message) {
        super(message);
    }
}
