package br.dev.bs.avaliacao.core.constantes;

import lombok.Getter;

@Getter
public enum TipoUsuario {
    ADMINISTRADOR("administrador"),
    AVALIADOR("avaliador"),
    USUARIO("usuario");

    private final String value;

    TipoUsuario(String value) {
        this.value = value;
    }

    public static TipoUsuario fromValue(String value) {
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.value.equalsIgnoreCase(value)) {
                return tipoUsuario;
            }
        }
        throw new IllegalArgumentException("Tipo de usuário inválido: " + value);
    }

}
