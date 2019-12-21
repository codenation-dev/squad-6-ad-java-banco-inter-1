package br.com.codenation.aceleradev.controller;

import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.dto.UsuarioDTO;
import br.com.codenation.aceleradev.service.UsuarioService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Usuário")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private static UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ApiOperation(value = "Retornar o usuário do <ID>.", notes = "Metódo para pesquisa do usuário pelo identificador cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário localizado com sucesso.", response = UsuarioDTO.class),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 404, message = "Usuário não localizado."),
            @ApiResponse(code = 500, message = "Houve um erro ao acessar o recurso")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@ApiParam(value = "Identificador do usuário para requisição.",
                                                         name = "Identificador",
                                                         required = true) @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @ApiOperation(value = "Retornar o usuário do <Email>.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário localizado com sucesso.", response = UsuarioDTO.class),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Houve um erro ao acessar o recurso.")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@ApiParam(value = "Email do usuário para requisição.",
                                                            name = "Email",
                                                            required = true) @PathVariable String email) {
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }

    @ApiOperation(value = "Salvar o usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário localizado com sucesso."),
            @ApiResponse(code = 201, message = "Usuário salvo com sucesso."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Houve um erro ao acessar o recurso")
    })
    @PostMapping
    public ResponseEntity<Void> salvar(@ApiParam(value = "Modelo do usuário",
                                                 name = "Usuário",
                                                 required = true) @RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @ApiOperation(value = "Atualizar o usuário pelo <ID>.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário localizado com sucesso."),
            @ApiResponse(code = 204, message = "Usuário processado."),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso."),
            @ApiResponse(code = 500, message = "Houve um erro ao acessar o recurso.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@ApiParam(value = "Identificador do usuário",
                                                 name = "Identificador",
                                                 required = true) @PathVariable Long id,
                                       @ApiParam(value = "Esquema para atualização do usuário",
                                                 name = "Modelo usuário",
                                                 required = true) @RequestBody Usuario usuario) {
        usuarioService.update(id, usuario);
        return ResponseEntity.noContent().build();
    }
}
