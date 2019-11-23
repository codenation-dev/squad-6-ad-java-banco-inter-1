package br.com.codenation.aceleradev.controller;

import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/erro")
public class ErroController {

    private ErroService service;

    @Autowired
    public ErroController(ErroService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Erro>> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findById(id));
    }
}
