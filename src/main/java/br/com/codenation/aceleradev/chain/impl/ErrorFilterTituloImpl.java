package br.com.codenation.aceleradev.chain.impl;

import br.com.codenation.aceleradev.chain.ErroFilterChain;
import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.dto.ErroFilterDTO;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ErrorFilterTituloImpl implements ErroFilterChain {

    private ErroFilterChain proximo;

    public ErrorFilterTituloImpl() {
        this.proximo = new ErrorFilterLevelImpl();
    }

    @Override
    public Page<Erro> filtra(ErroService erroService, Pageable pageable, AmbienteEnum ambiente, StatusEnum status, ErroFilterDTO erroFilter) {
        if(erroFilter.isTituloNotEmpty()) return erroService.findByAmbienteAndTitulo(pageable, ambiente, erroFilter.getTitulo());
        return proximo.filtra(erroService, pageable, ambiente, status, erroFilter);
    }

}
