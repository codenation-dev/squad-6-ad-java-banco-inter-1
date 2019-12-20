package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.domain.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @Before
    public void setUp(){
        usuario = new Usuario();
        usuario.setEmail("teste_repository@squad6.com.br");
        usuario.setNome("Teste repository");
        usuario.setSenha(new BCryptPasswordEncoder().encode("senhateste"));
        usuario.setToken("batata");
        usuarioRepository.save(usuario);
    }

    @Test
    public void testInsercaoDeUsuario(){
        assertEquals(usuario, usuarioRepository.findByEmail("teste_repository@squad6.com.br").get());
    }

    @After
    public void tearDown(){
        usuarioRepository.delete(usuario);
    }

}
