package br.dev.bs.avaliacao.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_resposta")
@NoArgsConstructor
@AllArgsConstructor
@Data @Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class RespostaEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_avaliacao")
    private AvaliacaoEntity avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_pergunta")
    private PerguntaEntity pergunta;

    @ManyToOne
    @JoinColumn(name = "id_alternativa")
    private AlternativaEntity alternativa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

}
