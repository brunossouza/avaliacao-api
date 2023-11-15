package br.dev.bs.avaliacao.api.v1;

import br.dev.bs.avaliacao.api.dtos.UsuarioDTO;
import br.dev.bs.avaliacao.domain.services.impl.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/usuarios")
public class UsuariosApiController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        var usuarios = usuarioService.findAll();

        if (usuarios.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(usuarios);
    }


}
