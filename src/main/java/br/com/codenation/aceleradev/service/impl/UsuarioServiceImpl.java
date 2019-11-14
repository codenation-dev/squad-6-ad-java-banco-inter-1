package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.repository.UsuarioRepository;
import br.com.codenation.aceleradev.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }
}
