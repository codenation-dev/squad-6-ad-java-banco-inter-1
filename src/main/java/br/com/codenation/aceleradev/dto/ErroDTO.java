package br.com.codenation.aceleradev.dto;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErroDTO {
    private Long id;
    private LocalDateTime createdAt;
    private AmbienteEnum ambiente;
    private LocalDateTime data;
    private String detalhes;
    private String endereco;
    private LevelEnum level;
    private StatusEnum status;
    private String titulo;
    private Long usuarioId;
    private String token;
    private Long frequencia;
}
