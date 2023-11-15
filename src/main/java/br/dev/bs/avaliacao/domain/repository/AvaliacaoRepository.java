package br.dev.bs.avaliacao.domain.repository;

import br.dev.bs.avaliacao.domain.models.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, UUID> {
}
