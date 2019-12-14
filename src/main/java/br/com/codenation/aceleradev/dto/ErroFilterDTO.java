package br.com.codenation.aceleradev.dto;

import br.com.codenation.aceleradev.comum.LevelEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Objects;


@Getter
@Setter
public class ErroFilterDTO {

    private String titulo;

    private LevelEnum level;

    private Long usuarioId;

    public boolean isTituloNotEmpty() {
        return !StringUtils.isEmpty(this.titulo);
    }

    public boolean isLevelNotNull() {
        return !Objects.isNull(this.level);
    }

    public boolean isUsuarioIdNotNull() {
        return !Objects.isNull(this.usuarioId);
    }
}
