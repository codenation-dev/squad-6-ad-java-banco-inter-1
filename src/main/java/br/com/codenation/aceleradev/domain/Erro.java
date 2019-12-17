package br.com.codenation.aceleradev.domain;

import br.com.codenation.aceleradev.comum.AmbienteEnum;
import br.com.codenation.aceleradev.comum.LevelEnum;
import br.com.codenation.aceleradev.comum.StatusEnum;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "erro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Erro extends BaseEntity{

    @Column(name = "titulo", length = 250, nullable = false, updatable = false)
    @Size(min = 10, max = 250)
    private String titulo;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "detalhes", nullable = false)
    private String detalhes;

    @ManyToOne
    private Usuario usuario;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "level", nullable = false)
    private LevelEnum level;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ambiente", nullable = false)
    private AmbienteEnum ambiente;

    @Column(name = "endereco", length = 150)
    @Size(max = 150)
    private String endereco;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private StatusEnum status;
}
