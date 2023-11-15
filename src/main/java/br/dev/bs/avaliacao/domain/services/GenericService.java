package br.dev.bs.avaliacao.domain.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GenericService<T1, T2> {
    public T2 save(T2 entity);

    public T2 update(T2 entity);

    public boolean delete(T2 entity);
    public boolean delete(UUID id);

    public T2 findById(UUID id);

    public List<T2> findAll();

}