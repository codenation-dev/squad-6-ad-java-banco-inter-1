package br.com.codenation.aceleradev.service;

import br.com.codenation.aceleradev.domain.Usuario;

public interface UsuarioService {
    void salvar(Usuario usuario);
    Usuario findById(Long id);
}
