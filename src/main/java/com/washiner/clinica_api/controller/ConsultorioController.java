package com.washiner.clinica_api.controller;

import com.washiner.clinica_api.dto.ConsultorioRequest;
import com.washiner.clinica_api.dto.ConsultorioResponse;
import com.washiner.clinica_api.service.ConsultorioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/consultorios")
@RequiredArgsConstructor
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    @PostMapping
    public ResponseEntity<ConsultorioResponse> criar(
            @RequestBody @Valid ConsultorioRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(consultorioService.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioResponse> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                consultorioService.buscarPorId(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<ConsultorioResponse>> listar() {
        return ResponseEntity.ok(
                consultorioService.listar()
        );
    }
}
