package school.sptech.lead.core.domain.lead.valueobject;

import school.sptech.lead.core.domain.shared.exception.ArgumentoInvalidoException;

public class GastoMensal {

    private double value;
    private Classificacao classificacao;

    private GastoMensal(double value, Classificacao classificacao) {
        this.value = value;
        this.classificacao = classificacao;
    }

    public static GastoMensal of(double value) {
        if (value <= 0.0) {
            throw new ArgumentoInvalidoException("Gasto mensal não pode menor que ou igual a 0.");
        }

        return new GastoMensal(value, Classificacao.ofValue(value));
    }

    public double getValue() {
        return value;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    @Override
    public String toString() {
        return "GastoMensal{" +
                "value=" + value +
                ", classificacao=" + classificacao +
                '}';
    }
}
