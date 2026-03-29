package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.TipoEspecialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EspecialidadeRequest(

        // nome não pode ser vazio
        @NotBlank
        String nome,

        // tipo não pode ser nulo pois é enum
        @NotNull
        TipoEspecialidade tipo
) {}
