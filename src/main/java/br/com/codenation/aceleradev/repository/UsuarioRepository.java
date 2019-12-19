package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.domain.Usuario;
import br.com.codenation.aceleradev.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT new br.com.codenation.aceleradev.dto.UsuarioDTO(" +
            " u.id, u.nome, u.token, u.email, u.role) FROM Usuario u WHERE u.id = :id")
    Optional<UsuarioDTO> getById(@Param("id") Long id);

    @Query(value = "SELECT new br.com.codenation.aceleradev.dto.UsuarioDTO(" +
            " u.id, u.nome, u.token, u.email, u.role) FROM Usuario u WHERE u.email = :email")
    Optional<UsuarioDTO> getByEmail(@Param("email") String email);

    Optional<Usuario> findByEmail(@Param("email") String email);
}
