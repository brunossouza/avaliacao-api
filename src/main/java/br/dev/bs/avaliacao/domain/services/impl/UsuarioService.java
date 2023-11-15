package br.dev.bs.avaliacao.domain.services.impl;

import br.dev.bs.avaliacao.api.dtos.UsuarioDTO;
import br.dev.bs.avaliacao.domain.mappers.MapperConverter;
import br.dev.bs.avaliacao.domain.models.UsuarioEntity;
import br.dev.bs.avaliacao.domain.repository.UsuarioRepository;
import br.dev.bs.avaliacao.domain.services.GenericService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService implements GenericService<UsuarioEntity, UsuarioDTO> {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO save(UsuarioDTO entity) {
        return null;
    }

    @Override
    public UsuarioDTO update(UsuarioDTO entity) {
        return null;
    }

    @Override
    public boolean delete(UsuarioDTO entity) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public UsuarioDTO findById(UUID id) {
        return null;
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream().map(MapperConverter::convertUsuarioEntityToDTO).toList();
    }
}
