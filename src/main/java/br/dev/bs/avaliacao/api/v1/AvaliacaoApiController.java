package br.dev.bs.avaliacao.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/avaliacao")
public class AvaliacaoApiController {

    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Hello World");
    }

}
