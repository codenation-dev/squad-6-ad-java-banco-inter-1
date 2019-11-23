package br.com.codenation.aceleradev.service;

import br.com.codenation.aceleradev.domain.Erro;

import java.util.Optional;

public interface ErroService {
    Optional<Erro> findById(Long erroId);
}
