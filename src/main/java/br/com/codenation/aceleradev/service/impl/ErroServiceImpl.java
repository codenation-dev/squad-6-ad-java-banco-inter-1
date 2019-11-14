package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.repository.ErroRepository;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErroServiceImpl implements ErroService {

    private ErroRepository repository;

    @Autowired
    public ErroServiceImpl(ErroRepository repository) {
        this.repository = repository;
    }
}
