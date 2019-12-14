package br.com.codenation.aceleradev.service;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.dto.ErroFilterDTO;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.domain.Erro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ErroService {
    Erro save(Erro erro);
    void update(Long id, Erro erro);
    void delete(Long id);
    Erro findById(Long id);
    Page<Erro> findAll(Pageable pageable);
    Page<Erro> findByTitulo(Pageable pageable, String titulo);
    Page<Erro> findByLevel(Pageable pageable, LevelEnum level);
    Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId);
    Page<Erro> findByAmbiente(Pageable pageable, AmbienteEnum ambiente);
    Page<Erro> findByAmbienteAndTitulo(Pageable pageable, AmbienteEnum ambiente, String titulo);
    Page<Erro> findByAmbienteAndLevel(Pageable pageable, AmbienteEnum ambiente, LevelEnum level);
    Page<Erro> findByAmbienteAndUsuarioId(Pageable pageable, AmbienteEnum ambiente, Long usuarioId);

    Page<Erro> findPaged(Pageable pageable, AmbienteEnum ambiente, ErroFilterDTO erroFilter);
}
