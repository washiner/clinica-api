package com.washiner.clinica_api.dto;

import jakarta.validation.constraints.NotNull;

public record ConsultorioRequest(

        // número do consultório
        @NotNull
        Integer numero,

        // andar do consultório
        @NotNull
        Integer andar,

        // id do médico dono do consultório
        @NotNull
        Long medicoId
) {}