package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.model.Consultorio;

public record ConsultorioResponse(
        Long id,
        Integer numero,
        Integer andar,
        // retorna o médico completo aninhado
        MedicoResponse medico
) {
    public static ConsultorioResponse from(Consultorio consultorio) {
        return new ConsultorioResponse(
                consultorio.getId(),
                consultorio.getNumero(),
                consultorio.getAndar(),
                // converte o Medico em MedicoResponse
                MedicoResponse.from(consultorio.getMedico())
        );
    }
}
