package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.domain.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErroRepositoryTest {

    @Autowired
    private ErroRepository erroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Erro erro;
    private Usuario usuario;

    @Before
    public void setUp(){

       // erroRepository.deleteAll();
        //usuarioRepository.deleteAll();

        usuario = new Usuario();
        usuario.setEmail("teste_repository@squad6.com.br");
        usuario.setNome("Teste repository");
        usuario.setSenha(new BCryptPasswordEncoder().encode("senhateste"));
        usuario.setToken("batata");
        usuarioRepository.save(usuario);

        erro = new Erro();
        erro.setStatus(StatusEnum.ATIVO);
        erro.setAmbiente(AmbienteEnum.DEV);
        erro.setLevel(LevelEnum.ERROR);
        erro.setData(LocalDateTime.now());
        erro.setEndereco("192.168.0.1");
        erro.setTitulo("Erro de teste");
        erro.setDetalhes("Detalhes de teste");
        erro.setUsuario(usuario);
        erroRepository.save(erro);
    }

    @Test
    public void testInsercaoDeErro(){
        assertEquals(erro, erroRepository.findById(erro.getId()).get());
    }


    @Test
    public void testFindAllErros(){
        assertEquals(7, erroRepository.count());
    }

    @After
    public void tearDown(){
        this.erroRepository.delete(erro);
        this.usuarioRepository.delete(usuario);
    }
}
