package br.com.codenation.aceleradev.controller;


import br.com.codenation.aceleradev.AbstractTest;
import br.com.codenation.aceleradev.comum.RoleEnum;
import br.com.codenation.aceleradev.domain.Usuario;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioControllerTest extends AbstractTest {
    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String secret;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    UsuarioService usuarioService;

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
    }

    @Test
    public void testAcessoEndpointUsuario() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/usuario/1111")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

   @Test
   public void testCriarUsuarioViaPost() throws Exception {
        String jsonUsuario = mapToJson(usuario);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonUsuario)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
   }

    @Test
    public void testRecuperarUsuarioViaGet() throws Exception {

        String jsonUsuario = "{\"id\":1111," +
                "\"createAt\":null," +
                "\"nome\":\"Raul F. Mansur\"," +
                "\"token\":\"hzqfm123zmufgo1mb51\"," +
                "\"senha\":\"$2y$12$YZU2Hl/./XF88tSC0Q4Hxu/M2UAhPdXZ3rSt9rLz6EdzI16pdKByW\"," +
                "\"email\":\"teste1@squad6.com.br\"}";

        Usuario usuario = mapFromJson(jsonUsuario, Usuario.class);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/usuario/1111")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String resultado = mvcResult.getResponse().getContentAsString();

        assertEquals(usuario, mapFromJson(resultado, Usuario.class));
    }


    @After
    public void tearDown(){

    }

}
