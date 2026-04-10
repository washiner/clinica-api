package com.washiner.clinica_api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequest(

        // data e hora da consulta no formato ISO
        // ex: "2026-04-10T14:30:00"
        @NotNull
        LocalDateTime dataHora,

        // observação é opcional — pode ser null
        String observacao,

        // id do médico que vai realizar a consulta
        @NotNull
        Long medicoId,

        // id do paciente que vai ser atendido
        @NotNull
        Long pacienteId
) {}
