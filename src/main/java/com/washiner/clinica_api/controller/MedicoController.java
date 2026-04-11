package com.washiner.clinica_api.controller;

import com.washiner.clinica_api.dto.MedicoRequest;
import com.washiner.clinica_api.dto.MedicoResponse;
import com.washiner.clinica_api.service.MedicoService;
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
@RequestMapping("/v1/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponse> criar(
            @RequestBody @Valid MedicoRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(medicoService.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> buscarPorId(
            @PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarPorId(id));
    }

    // antes estava assim
//    @GetMapping
//    public ResponseEntity<List<MedicoResponse>> listar() {
//        return ResponseEntity.ok(medicoService.listar());
//    }

    // agora fica assim
    @GetMapping
    public ResponseEntity<Page<MedicoResponse>> listar(
            // @PageableDefault define os valores padrão
            // se o cliente não passar nada na URL
            // page = 0    → primeira página
            // size = 10   → 10 itens por página
            // sort = nome → ordenado por nome
            @PageableDefault(page = 0, size = 10, sort = "nome")
            Pageable pageable) {
        return ResponseEntity.ok(medicoService.listar(pageable));
    }
}
