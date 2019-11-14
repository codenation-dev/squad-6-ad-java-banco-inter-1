package br.com.codenation.aceleradev.repository;

import br.com.codenation.aceleradev.domain.Erro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErroRepository extends JpaRepository<Erro, Long> {
}
