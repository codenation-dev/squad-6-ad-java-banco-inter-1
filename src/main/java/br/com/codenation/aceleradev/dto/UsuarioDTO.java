package br.com.codenation.aceleradev.dto;
import br.com.codenation.aceleradev.comum.RoleEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@ApiModel(value = "Modelo de Usuário")
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    @ApiModelProperty(value = "Identificador", example = "1")
    private Long id;
    @ApiModelProperty(value = "Nome do usuário", example = "Paulo Pedro")
    private String nome;
    @ApiModelProperty(value = "Token", example = "7aaee0e2-6884-4fd7-ba63-21d76723dce2")
    private String token;
    @ApiModelProperty(value = "Email do usuário", example = "email@email.com.br")
    private String email;
    @ApiModelProperty(value = "Permissões do usuário", example = "ADMIN")
    private RoleEnum role;
}