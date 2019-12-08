package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.exception.ResourceNotFoundException;
import br.com.codenation.aceleradev.repository.UsuarioRepository;
import br.com.codenation.aceleradev.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    @Override
    public void salvar(Usuario usuario) {
        Usuario usuarioComSenhaEncriptografada = usuario;
        usuarioComSenhaEncriptografada.setSenha(passwordEncoder.encode(usuario.getSenha()));
        System.out.println(usuarioComSenhaEncriptografada.getSenha());
        usuarioRepository.save(usuarioComSenhaEncriptografada);
    }

    @Override
    public void update(Long id, Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
