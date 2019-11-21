package br.com.codenation.aceleradev.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErroRepositoryTest {

    @Autowired
    private ErroRepository erroRepository;


    @Before
    public void setUp(){

    }

    @Test
    public void testExemplo(){

    }

    @After
    public void tearDown(){
        this.erroRepository.deleteAll();
    }
}
