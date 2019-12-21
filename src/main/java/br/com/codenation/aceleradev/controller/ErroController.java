package br.com.codenation.aceleradev.controller;

import br.com.codenation.aceleradev.chain.ErroFilterChain;
import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.dto.ErroDTO;
import br.com.codenation.aceleradev.dto.ErroFilterDTO;
import br.com.codenation.aceleradev.service.ErroService;
import br.com.codenation.aceleradev.service.impl.ErroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/erro")
public class ErroController {

    private final ErroService erroService;

    @Autowired
    public ErroController(ErroServiceImpl erroServiceImpl, List<ErroFilterChain> erroFilterChain) {
        this.erroService = erroServiceImpl;
    }

    @GetMapping
    public ResponseEntity<Page<ErroDTO>> findAll(@PageableDefault(sort = "data", direction = Sort.Direction.DESC, page = 0, size = 8) Pageable pageable,
                                                 @RequestParam(value = "status", required = true) StatusEnum status) {
        return ResponseEntity.ok(erroService.findAllErroDTO(pageable, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Erro> findById(@PathVariable Long id) {
        return ResponseEntity.ok(erroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Erro> save(@RequestBody Erro erro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(erroService.save(erro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Erro erro) {
        erroService.update(id, erro);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        erroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ambiente/{ambiente}")
    public ResponseEntity<Page<Erro>> findByTituloOrByLevelOrByUsuarioIdOrByAmbiente(@PageableDefault(sort = "data", direction = Sort.Direction.DESC, page = 0, size = 8) Pageable pageable,
                                                                                     @PathVariable AmbienteEnum ambiente,
                                                                                     @RequestParam(value = "status", required = true) StatusEnum status,
                                                                                     ErroFilterDTO erroFilter) {

        return ResponseEntity.ok(erroService.findPaged(pageable, ambiente, status, erroFilter));
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Page<Erro>> findByTitulo(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable,
                                                   @PathVariable String titulo) {

        return ResponseEntity.ok(erroService.findByTitulo(pageable, titulo));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<Page<Erro>> findByLevel(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable,
                                                  @PathVariable LevelEnum level) {
        return ResponseEntity.ok(erroService.findByLevel(pageable, level));
    }

    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<Page<Erro>> findByUsuarioId(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable,
                                                      @PathVariable Long usuarioId) {
        return ResponseEntity.ok(erroService.findByUsuarioId(pageable, usuarioId));
    }

    @PutMapping("/updateStatus/{statusCode}")
    public ResponseEntity<Void> updateStatus(@RequestBody List<Long> listaIds, @PathVariable StatusEnum statusCode) {
        for (Long id : listaIds) {
            Erro erro = erroService.findById(id);
            erro.setStatus(statusCode);
            erroService.update(id, erro);
        }
        return ResponseEntity.noContent().build();
    }

}