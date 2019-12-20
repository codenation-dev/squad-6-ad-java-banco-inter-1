package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.comum.RoleEnum;
import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.dto.UsuarioDTO;
import br.com.codenation.aceleradev.exception.ResourceNotFoundException;
import br.com.codenation.aceleradev.repository.UsuarioRepository;
import br.com.codenation.aceleradev.service.UsuarioService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public UsuarioDTO findById(Long id) {
        return usuarioRepository.getById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        return usuarioRepository.getByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    @Override
    public void salvar(Usuario usuario) {
        Usuario usuarioComSenhaEncriptografada = usuario;
        usuarioComSenhaEncriptografada.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioComSenhaEncriptografada.setToken(criarToken(usuario.toString()));

        if(Objects.isNull(usuario.getRole())){
            usuarioComSenhaEncriptografada.setRole(RoleEnum.USER);
        }
        usuarioRepository.save(usuarioComSenhaEncriptografada);
    }

    @Override
    public void update(Long id, Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public String criarToken(String conteudo){
        return DigestUtils.sha1Hex(conteudo);
    }

}
