package br.com.codenation.aceleradev.service.impl;

import br.com.codenation.aceleradev.chain.impl.ErrorFilterTituloImpl;
import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.dto.ErroDTO;
import br.com.codenation.aceleradev.dto.ErroFilterDTO;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.exception.ResourceNotFoundException;
import br.com.codenation.aceleradev.repository.ErroRepository;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ErroServiceImpl implements ErroService {

    private final ErroRepository repository;

    @Autowired
    public ErroServiceImpl(ErroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Erro findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro não encontrado"));
    }

    @Override
    public Erro save(Erro erro) {
        return repository.save(erro);
    }

    @Override
    public void update(Long id, Erro erro) {
        repository.save(erro);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<ErroDTO> findAllErroDTO(Pageable pageable, StatusEnum status){
        return repository.findAllErroDTO(pageable, status);
    }

    @Override
    public Page<Erro> findByTitulo(Pageable pageable, String titulo) {
        return repository.findByTitulo(pageable, titulo);
    }

    @Override
    public Page<Erro> findByLevel(Pageable pageable, LevelEnum level) {
        return repository.findByLevel(pageable, level);
    }

    @Override
    public Page<Erro> findByUsuarioId(Pageable pageable, Long usuarioId) {
        return repository.findByUsuarioId(pageable, usuarioId);
    }

    @Override
    public Page<Erro> findByAmbiente(Pageable pageable, AmbienteEnum ambiente, StatusEnum status) {
        return repository.findByAmbiente(pageable, ambiente, status);
    }

    @Override
    public Page<Erro> findByAmbienteAndTitulo(Pageable pageable, AmbienteEnum ambiente, String titulo) {
        return repository.findByAmbienteAndTitulo(pageable, ambiente, titulo);
    }

    @Override
    public Page<Erro> findByAmbienteAndLevel(Pageable pageable, AmbienteEnum ambiente, LevelEnum level) {
        return repository.findByAmbienteAndLevel(pageable, ambiente, level);
    }

    @Override
    public Page<Erro> findByAmbienteAndUsuarioId(Pageable pageable, AmbienteEnum ambiente, Long usuarioId) {
        return repository.findByAmbienteAndUsuarioId(pageable, ambiente, usuarioId);
    }

    @Override
    public Page<Erro> findPaged(Pageable pageable, AmbienteEnum ambiente, StatusEnum status, ErroFilterDTO erroFilter) {
        return new ErrorFilterTituloImpl().filtra(this, pageable, ambiente, status, erroFilter);
    }


    @Override
    public Long countDistinctByAmbienteAndLevelAndTitulo(AmbienteEnum ambiente, LevelEnum level, String titulo) {
        return repository.countDistinctByAmbienteAndLevelAndTitulo(ambiente, level, titulo).orElse(0L);
    }
}
