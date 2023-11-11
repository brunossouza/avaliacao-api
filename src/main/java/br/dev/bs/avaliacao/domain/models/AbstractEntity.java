package br.dev.bs.avaliacao.domain.models;

import br.dev.bs.avaliacao.utils.DataUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Data de cadastro do dado
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_criacao", nullable = false)
    @CreatedDate
    private Calendar dtCriacao;

    //Data de alteração do dado
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_atualizacao")
    @LastModifiedDate
    private Calendar dtAtualizacao;

    public String getDtCriacaoAsString() {
        if(dtCriacao==null){
            return "sem data de criação";
        }
        return DataUtils.formatarData(dtCriacao, "dd/MM/yyyy HH:mm:ss");
    }

    public String getDtAtualizacaoAsString() {
        if(dtAtualizacao==null){
            return "noUpdateDate";
        }
        return DataUtils.formatarData(dtAtualizacao, "dd/MM/yyyy HH:mm:ss");
    }
}
