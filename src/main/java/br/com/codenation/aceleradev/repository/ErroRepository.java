package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.domain.Erro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErroRepository extends JpaRepository<Erro, Long> {
    Page<Erro> findByTitulo(Pageable pageable, String titulo);
    Page<Erro> findByLevel(Pageable pageable, LevelEnum level);
    Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId);
}
