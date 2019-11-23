package br.com.codenation.aceleradev.service;

import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.domain.Erro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ErroService {
    public Erro findById(Long id);
    public Erro save(Erro erro);
    public void update(Long id, Erro erro);
    public void delete(Long id);
    public Page<Erro> findAll(Pageable pageable);
    public Page<Erro> findByTitulo(Pageable pageable, String titulo);
    public Page<Erro> findByLevel(Pageable pageable, LevelEnum level);
    public Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId);
}
