package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
