package br.com.codenation.aceleradev.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Before
    public void setUp(){

    }

    @Test
    public void testExemplo(){

    }

    @After
    public void tearDown(){
        this.usuarioRepository.deleteAll();
    }

}
