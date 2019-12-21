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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Erro")
@RestController
@RequestMapping("/erro")
public class ErroController {

    private final ErroService erroService;

    @Autowired
    public ErroController(ErroServiceImpl erroServiceImpl, List<ErroFilterChain> erroFilterChain) {
        this.erroService = erroServiceImpl;
    }

    @ApiOperation(value = "Pesquisar todos.", notes = "Metódo para pesquisa de todos os logs de erros catalogados.")
    @GetMapping
    public ResponseEntity<Page<ErroDTO>> findAll(@PageableDefault(sort = "data", direction = Sort.Direction.DESC, page = 0, size = 8) Pageable pageable,
                                                 @RequestParam(value = "status", required = true) StatusEnum status) {
        return ResponseEntity.ok(erroService.findAllErroDTO(pageable, status));
    }

    @ApiOperation(value = "Pesquisar Identificador.", notes = "Metódo para pesquisa por identificador dos logs de erros catalogados.")
    @GetMapping("/{id}")
    public ResponseEntity<Erro> findById(@PathVariable Long id) {
        return ResponseEntity.ok(erroService.findById(id));
    }

    @ApiOperation(value = "Salvar", notes = "Metódo para salvar o logs de erros.")
    @PostMapping
    public ResponseEntity<Erro> save(@RequestBody Erro erro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(erroService.save(erro));
    }

    @ApiOperation(value = "Atualizar", notes = "Metódo para atualizar o logs de erros.")
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Erro erro) {
        erroService.update(id, erro);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deletar", notes = "Metódo para deletar o logs de erros pelo <ID>.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        erroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Localizar por ambiente.", notes = "Metódo para localizar os logs pelo ambiente paginado.")
    @GetMapping("/ambiente/{ambiente}")
    public ResponseEntity<Page<Erro>> findByTituloOrByLevelOrByUsuarioIdOrByAmbiente(@PageableDefault(sort = "data", direction = Sort.Direction.DESC, page = 0, size = 8) Pageable pageable,
                                                                                     @PathVariable AmbienteEnum ambiente,
                                                                                     @RequestParam(value = "status", required = true) StatusEnum status,
                                                                                     ErroFilterDTO erroFilter) {

        return ResponseEntity.ok(erroService.findPaged(pageable, ambiente, status, erroFilter));
    }

    @ApiOperation(value = "Localizar por titulo.", notes = "Metódo para localizar os logs pelo titulo paginado.")
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Page<Erro>> findByTitulo(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable,
                                                   @PathVariable String titulo) {

        return ResponseEntity.ok(erroService.findByTitulo(pageable, titulo));
    }

    @ApiOperation(value = "Localizar por level.", notes = "Metódo para localizar os logs pelo level paginado.")
    @GetMapping("/level/{level}")
    public ResponseEntity<Page<Erro>> findByLevel(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable,
                                                  @PathVariable LevelEnum level) {
        return ResponseEntity.ok(erroService.findByLevel(pageable, level));
    }

    @ApiOperation(value = "Localizar por usuário.", notes = "Metódo para localizar os logs pelo usuário paginado.")
    @GetMapping("/usuarioId/{usuarioId}")
    public ResponseEntity<Page<Erro>> findByUsuarioId(@PageableDefault(sort = "titulo", direction = Sort.Direction.ASC, page = 0, size = 8) Pageable pageable,
                                                      @PathVariable Long usuarioId) {
        return ResponseEntity.ok(erroService.findByUsuarioId(pageable, usuarioId));
    }

    @ApiOperation(value = "Atualizar status.", notes = "Metódo para atualizar o status dos logs pelos identificadores repassados.")
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