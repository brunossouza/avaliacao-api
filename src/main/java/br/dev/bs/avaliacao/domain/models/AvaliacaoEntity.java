package br.dev.bs.avaliacao.domain.models;

import br.dev.bs.avaliacao.core.constantes.TipoAvaliacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "tb_avaliacao")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class AvaliacaoEntity extends AbstractEntity {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvaliacao;

    @Column(name = "st_ordernada")
    private boolean ordernada; // true = ordernada, false = aleatoria.

    @Column(name = "st_ativo")
    private boolean ativo;

    @Column(name = "dt_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dtInicio;

    @Column(name = "dt_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dtFim;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

}
