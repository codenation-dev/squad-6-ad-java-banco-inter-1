package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.repository.UsuarioRepository;
import br.com.codenation.aceleradev.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static UsuarioRepository repository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }
}
