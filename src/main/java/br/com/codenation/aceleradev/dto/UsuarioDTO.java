package br.com.codenation.aceleradev.dto;
import br.com.codenation.aceleradev.comum.RoleEnum;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String token;
    private String email;
    private RoleEnum role;
}