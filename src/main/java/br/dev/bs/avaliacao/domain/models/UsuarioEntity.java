package br.dev.bs.avaliacao.domain.models;

import br.dev.bs.avaliacao.core.constantes.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data @Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class UsuarioEntity extends AbstractEntity {

    @Column(name = "nome")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(name = "email")
    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Column(name = "senha")
    @NotBlank(message = "Senha é obrigatório")
    private String senha;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "st_ativo")
    @NotNull(message = "O campo ativo é obrigatório")
    private boolean ativo;

}
