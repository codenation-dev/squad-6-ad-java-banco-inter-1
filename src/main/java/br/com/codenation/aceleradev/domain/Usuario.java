package br.com.codenation.aceleradev.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Usuario extends BaseEntity {

    @Column(name = "nome", length = 150, nullable = false)
    @Size(min=3, max = 150)
    private String nome;

    @Column(name="token", length = 255)
    @Size(max = 255)
    private String token;

    @Column(name="senha")
    private String senha;

    @Column(name="email", length = 150)
    @Email
    private String email;
}
