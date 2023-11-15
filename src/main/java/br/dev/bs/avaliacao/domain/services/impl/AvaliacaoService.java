package br.dev.bs.avaliacao.domain.services.impl;

import br.dev.bs.avaliacao.api.dtos.AvaliacaoDTO;
import br.dev.bs.avaliacao.domain.models.AvaliacaoEntity;
import br.dev.bs.avaliacao.domain.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AvaliacaoService implements GenericService<AvaliacaoEntity, AvaliacaoDTO> {
    @Override
    public AvaliacaoDTO save(AvaliacaoDTO entity) {
        return null;
    }

    @Override
    public AvaliacaoDTO update(AvaliacaoDTO entity) {
        return null;
    }

    @Override
    public boolean delete(AvaliacaoDTO entity) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public AvaliacaoDTO findById(UUID id) {
        return null;
    }

    @Override
    public List<AvaliacaoDTO> findAll() {
        return null;
    }
}
