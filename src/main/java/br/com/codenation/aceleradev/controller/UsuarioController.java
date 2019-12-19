package br.com.codenation.aceleradev.controller;

import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.dto.UsuarioDTO;
import br.com.codenation.aceleradev.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private static UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.update(id, usuario);
        return ResponseEntity.noContent().build();
    }
}
