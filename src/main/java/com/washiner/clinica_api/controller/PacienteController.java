package com.washiner.clinica_api.controller;

import com.washiner.clinica_api.dto.PacienteRequest;
import com.washiner.clinica_api.dto.PacienteResponse;
import com.washiner.clinica_api.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponse> criar(
            @RequestBody @Valid PacienteRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pacienteService.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                pacienteService.buscarPorId(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listar() {
        return ResponseEntity.ok(
                pacienteService.listar()
        );
    }
}