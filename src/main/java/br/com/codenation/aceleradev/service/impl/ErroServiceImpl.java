package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.exception.ResourceNotFoundException;
import br.com.codenation.aceleradev.repository.ErroRepository;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ErroServiceImpl implements ErroService {

    private static ErroRepository repository;

    @Autowired
    public ErroServiceImpl(ErroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Erro findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro não encontrado"));
    }

    @Override
    public Erro save(Erro erro) {
        return repository.save(erro);
    }

    @Override
    public void update(Long id, Erro erro) {
        repository.save(erro);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Erro> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Erro> findByTitulo(Pageable pageable, String titulo) {
        return repository.findByTitulo(pageable, titulo);
    }

    @Override
    public Page<Erro> findByLevel(Pageable pageable, LevelEnum level) {
        return repository.findByLevel(pageable, level);
    }

    @Override
    public Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId) {
        return repository.findByUsuarioId(pageable, usuarioId);
    }
}
