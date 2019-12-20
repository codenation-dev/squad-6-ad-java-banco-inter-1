package br.com.codenation.aceleradev.chain;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import br.com.codenation.aceleradev.dto.ErroFilterDTO;
import br.com.codenation.aceleradev.domain.Erro;
import br.com.codenation.aceleradev.service.ErroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ErroFilterChain {

    Page<Erro> filtra(ErroService erroService, Pageable pageable, AmbienteEnum ambiente, StatusEnum status,ErroFilterDTO erroFilter);

}
