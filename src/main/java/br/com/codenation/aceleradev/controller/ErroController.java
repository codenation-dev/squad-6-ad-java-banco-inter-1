package br.com.codenation.aceleradev.controller;

import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/erro")
public class ErroController {

    private ErroService service;

    @Autowired
    public ErroController(ErroService service) {
        this.service = service;
    }
}
