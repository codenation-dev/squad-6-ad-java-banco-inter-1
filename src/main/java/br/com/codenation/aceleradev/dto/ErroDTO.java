package br.com.codenation.aceleradev.dto;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

public interface ErroDTO {
    Long getId();
    LocalDateTime getCreatedAt();
    AmbienteEnum getAmbiente();
    LocalDateTime getData();
    String getDetalhes();
    String getEndereco();
    LevelEnum getLevel();
    StatusEnum getStatus();
    String getTitulo();
    Long getUsuarioId();
    Long getFrequencia();
}
