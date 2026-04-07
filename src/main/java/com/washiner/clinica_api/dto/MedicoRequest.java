package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.TipoContrato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MedicoRequest(

        @NotBlank
        String nome,

        // crm obrigatório e único
        @NotBlank
        String crm,

        @NotNull
        TipoContrato tipoContrato,

        // lista de ids das especialidades do médico
        // o médico pode ter mais de uma especialidade
        @NotNull
        List<Long> especialidadeIds
) {}