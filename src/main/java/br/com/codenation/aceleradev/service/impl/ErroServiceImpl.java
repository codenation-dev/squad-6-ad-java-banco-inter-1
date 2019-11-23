package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.repository.ErroRepository;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ErroServiceImpl implements ErroService {

    private ErroRepository repository;

    @Autowired
    public ErroServiceImpl(ErroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Erro> findById(Long erroId) {
        return repository.findById(erroId);
    }
}
