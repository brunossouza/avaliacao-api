package br.dev.bs.avaliacao.core.constantes;

import lombok.Getter;

@Getter
public enum TipoAvaliacao {
    PROVA("prova"),
    PESQUISA("pesquisa");

    private final String value;

    TipoAvaliacao(String value) {
        this.value = value;
    }

    public static TipoAvaliacao fromValue(String value) {
        for (TipoAvaliacao tipoAvaliacao : TipoAvaliacao.values()) {
            if (tipoAvaliacao.value.equalsIgnoreCase(value)) {
                return tipoAvaliacao;
            }
        }
        throw new IllegalArgumentException("Tipo de avaliação inválida: " + value);
    }
}

