package com.washiner.clinica_api.controller;

import com.washiner.clinica_api.dto.ConsultaRequest;
import com.washiner.clinica_api.dto.ConsultaResponse;
import com.washiner.clinica_api.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponse> criar(
            @RequestBody @Valid ConsultaRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(consultaService.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                consultaService.buscarPorId(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> listar() {
        return ResponseEntity.ok(
                consultaService.listar()
        );
    }
}