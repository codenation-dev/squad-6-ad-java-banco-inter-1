package br.com.codenation.aceleradev.controller;

import br.com.codenation.aceleradev.AbstractTest;
import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.RoleEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.service.ErroService;
import br.com.codenation.aceleradev.service.UsuarioService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ErroControllerTest extends AbstractTest {

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String secret;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ErroService erroService;

    @Autowired
    private UsuarioService usuarioService;

    private Erro erro;
    private Usuario usuario;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        usuario = new Usuario();
        usuario.setEmail("teste_controller_user@squad6.com.br");
        usuario.setNome("Teste controller user");
        usuario.setSenha(new BCryptPasswordEncoder().encode("senhateste"));
        usuario.setRole(RoleEnum.ADMIN);

        usuarioService.salvar(usuario);

        erro = new Erro();
        erro.setStatus(StatusEnum.ATIVO);
        erro.setAmbiente(AmbienteEnum.DEV);
        erro.setLevel(LevelEnum.ERROR);
        erro.setData(LocalDateTime.now());
        erro.setEndereco("192.168.0.1");
        erro.setTitulo("Erro de teste");
        erro.setDetalhes("Detalhes de teste");
        erro.setUsuario(usuario);

        erroService.save(erro);

    }

    @Test
    public void testAcessoEndpointErro() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/erro/")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @After
    public void tearDown(){

    }

}
