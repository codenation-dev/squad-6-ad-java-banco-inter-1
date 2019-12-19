package br.com.codenation.aceleradev.service;

import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.dto.UsuarioDTO;

public interface UsuarioService {
    void salvar(Usuario usuario);
    UsuarioDTO findById(Long id);
    UsuarioDTO findByEmail(String email);
    void update(Long id, Usuario usuario);
}
