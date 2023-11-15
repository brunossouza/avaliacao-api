package br.dev.bs.avaliacao.api.dtos;

import java.util.Calendar;
import java.util.UUID;

public record UsuarioDTO(
        UUID id,
        String nome,
        String email,
        String tipo,
        boolean ativo,
        Calendar dtCriacao,
        Calendar dtAtualizacao
        ) {
}
