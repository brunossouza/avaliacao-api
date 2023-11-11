package br.dev.bs.avaliacao.domain.models;

import br.dev.bs.avaliacao.core.constantes.TipoPergunta;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pergunta")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class PerguntaEntity extends AbstractEntity {

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoPergunta tipoPergunta;

    @Column(name = "ordem")
    private int ordem;

    @Column(name = "st_ativo")
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_avaliacao")
    private AvaliacaoEntity avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

}
