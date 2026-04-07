package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.TipoContrato;
import com.washiner.clinica_api.model.Medico;

import java.util.List;

public record MedicoResponse(
        Long id,
        String nome,
        String crm,
        TipoContrato tipoContrato,
        Boolean ativo,
        // retorna a lista de especialidades completas
        List<EspecialidadeResponse> especialidades
) {
    public static MedicoResponse from(Medico medico) {
        return new MedicoResponse(
                medico.getId(),
                medico.getNome(),
                medico.getCrm(),
                medico.getTipoContrato(),
                medico.getAtivo(),
                // converte cada Especialidade em EspecialidadeResponse
                medico.getEspecialidades()
                        .stream()
                        .map(EspecialidadeResponse::from)
                        .toList()
        );
    }
}