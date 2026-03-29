package com.washiner.clinica_api.exception;

public record ErroResponse(
        int status,
        String mensagem
) {}
