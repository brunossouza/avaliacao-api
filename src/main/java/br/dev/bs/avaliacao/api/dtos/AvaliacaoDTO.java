package br.dev.bs.avaliacao.api.dtos;

import java.util.Calendar;
import java.util.UUID;

public record AvaliacaoDTO(
        UUID id,
        String titulo,
        String descricao,
        String tipo,
        boolean ordernada,
        boolean ativo,
        Calendar dtInicio,
        Calendar dtFim
) {
}
