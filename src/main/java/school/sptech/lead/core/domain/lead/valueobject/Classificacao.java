package school.sptech.lead.core.domain.lead.valueobject;

import school.sptech.lead.core.domain.shared.exception.ArgumentoInvalidoException;

import java.util.Comparator;
import java.util.Objects;

/**
 * Classificação do lead conforme consumo mensal.
 * <p>
 * Regras:
 * BAIXO:  consumo  < 100                         → prioridade 4 → “Nutrição mensal por e-mail”
 * MÉDIO:  100 ≤ consumo < 300                    → prioridade 3 → “Contato em até 72h + material educativo”
 * ALTO:   300 ≤ consumo < 700                    → prioridade 2 → “Contato em até 48h + proposta personalizada”
 * VIP:    consumo ≥ 700                          → prioridade 1 → “Contato em até 24h + consultoria especializada”
 */
public enum Classificacao {

    // O Solid
    BAIXO("Nutrição mensal por e-mail", 4, 0.0, 100.0),
    MEDIO("Contato em até 72h + material educativo", 3, 100.0, 300.0),
    ALTO("Contato em até 48h + proposta personalizada", 2, 300.0, 700.0),
    VIP("Contato em até 24h + consultoria especializada", 1, 700.0, Double.POSITIVE_INFINITY);

    private final String descricao;

    private final int prioridade;

    private final double minimoInclusive;

    private final double maximoExclusive;

    Classificacao(String descricao, int prioridade, double minimoInclusive, double maximoExclusive) {
        this.descricao = Objects.requireNonNull(descricao, "descricao");
        this.prioridade = prioridade;
        this.minimoInclusive = minimoInclusive;
        this.maximoExclusive = maximoExclusive;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public double getMinimoInclusive() {
        return minimoInclusive;
    }

    public double getMaximoExclusive() {
        return maximoExclusive;
    }

    public boolean contains(double consumo) {
        return consumo >= minimoInclusive && consumo < maximoExclusive;
    }

    public static Classificacao ofValue(double consumo) {
        if (Double.isNaN(consumo) || Double.isInfinite(consumo) || consumo < 0.0) {
            throw new ArgumentoInvalidoException("Consumo inválido: " + consumo);
        }
        for (Classificacao classificacao : values()) {
            if (classificacao.contains(consumo)) {
                return classificacao;
            }
        }

        // Tecnicamente não alcançável dado o VIP até +∞, mas deixamos por segurança.
        throw new IllegalStateException("Nenhuma classificação encontrada para consumo: " + consumo);
    }

    @Override
    public String toString() {
        return name() + " (prioridade " + prioridade + " | " + descricao + ")";
    }
}
