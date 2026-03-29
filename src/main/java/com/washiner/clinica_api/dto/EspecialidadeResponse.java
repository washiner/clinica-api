package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.TipoEspecialidade;
import com.washiner.clinica_api.model.Especialidade;

public record EspecialidadeResponse(
        Long id,
        String nome,
        TipoEspecialidade tipo,
        Boolean ativa
) {
    // converte o model Especialidade em EspecialidadeResponse
    public static EspecialidadeResponse from(Especialidade especialidade) {
        return new EspecialidadeResponse(
                especialidade.getId(),
                especialidade.getNome(),
                especialidade.getTipo(),
                especialidade.getAtiva()
        );
    }
}
