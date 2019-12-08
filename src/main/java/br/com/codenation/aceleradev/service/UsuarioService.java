package br.com.codenation.aceleradev.service;

import br.com.codenation.aceleradev.domain.Usuario;

public interface UsuarioService {
    void salvar(Usuario usuario);
    Usuario findById(Long id);
    Usuario findByEmail(String email);
    void update(Long id, Usuario usuario);
}
