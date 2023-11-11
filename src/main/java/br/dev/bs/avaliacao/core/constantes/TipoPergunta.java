package br.dev.bs.avaliacao.core.constantes;

import lombok.Getter;

@Getter
public enum TipoPergunta {
    ABERTA("aberta"), MULTIPLA_ESCOLHA("multipla escolha"), ESCOLHA_UNICA("escolha unica");

    private final String value;

    TipoPergunta(String value) {
        this.value = value;
    }

    public static TipoPergunta fromValue(String value) {
        for (TipoPergunta tipoPergunta : TipoPergunta.values()) {
            if (tipoPergunta.value.equalsIgnoreCase(value)) {
                return tipoPergunta;
            }
        }
        throw new IllegalArgumentException("Tipo de pergunta inválida: " + value);
    }
}
