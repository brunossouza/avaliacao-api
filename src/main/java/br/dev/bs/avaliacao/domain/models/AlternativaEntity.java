package br.dev.bs.avaliacao.domain.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_alternativa")
@NoArgsConstructor
@AllArgsConstructor
@Data @Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class AlternativaEntity extends AbstractEntity {

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "st_correta")
    private boolean correta;

    @Column(name = "st_ativo")
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private PerguntaEntity pergunta;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

}
