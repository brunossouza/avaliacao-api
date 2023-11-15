package br.dev.bs.avaliacao.domain.mappers;

import br.dev.bs.avaliacao.api.dtos.UsuarioDTO;
import br.dev.bs.avaliacao.domain.models.UsuarioEntity;

//TODO: Implementar o MapperConverter para converter a qualquer entidade para DTO e vice-versa
public class MapperConverter {
    public static UsuarioDTO convertUsuarioEntityToDTO(UsuarioEntity entity){
        return new UsuarioDTO(entity.getId(),entity.getNome(), entity.getEmail(), entity.getTipo().name(), entity.isAtivo(), entity.getDtCriacao(), entity.getDtAtualizacao());
    }
}
