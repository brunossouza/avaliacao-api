package br.dev.bs.avaliacao.core.constantes;

import lombok.Getter;

@Getter
public enum TipoOrdenacao {
    ORDENADA("ordenada"),
    ALERATORIA("aleatoria");

    private final String value;

    TipoOrdenacao(String value) {
        this.value = value;
    }

    public static TipoOrdenacao fromValue(String value) {
        for (TipoOrdenacao tipoOrdenacao : TipoOrdenacao.values()) {
            if (tipoOrdenacao.getValue().equals(value)) {
                return tipoOrdenacao;
            }
        }
        throw new IllegalArgumentException("Tipo de ordenação inválida: " + value);
    }

}
