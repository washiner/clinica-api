package com.washiner.clinica_api.controller;

import com.washiner.clinica_api.dto.EspecialidadeRequest;
import com.washiner.clinica_api.dto.EspecialidadeResponse;
import com.washiner.clinica_api.service.EspecialidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    // POST /v1/especialidades — cadastra nova especialidade
    @PostMapping
    public ResponseEntity<EspecialidadeResponse> criar(
            @RequestBody @Valid EspecialidadeRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(especialidadeService.criar(request));
    }

    // GET /v1/especialidades/{id} — busca especialidade por id
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadeResponse> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                especialidadeService.buscarPorId(id)
        );
    }

    // GET /v1/especialidades — lista todas
    @GetMapping
    public ResponseEntity<List<EspecialidadeResponse>> listar() {
        return ResponseEntity.ok(
                especialidadeService.listar()
        );
    }
}
