package com.washiner.clinica_api.controller;

import com.washiner.clinica_api.dto.ConsultaRequest;
import com.washiner.clinica_api.dto.ConsultaResponse;
import com.washiner.clinica_api.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<ConsultaResponse>> listar(
            // padrão — página 0, 10 por página, ordenado por dataHora
            @PageableDefault(page = 0, size = 10, sort = "dataHora")
            Pageable pageable) {
        return ResponseEntity.ok(consultaService.listar(pageable));
    }
}