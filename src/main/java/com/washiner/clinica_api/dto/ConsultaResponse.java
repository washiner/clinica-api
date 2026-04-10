package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.StatusConsulta;
import com.washiner.clinica_api.model.Consulta;

import java.time.LocalDateTime;

public record ConsultaResponse(
        Long id,
        LocalDateTime dataHora,
        StatusConsulta status,
        String observacao,
        // retorna o médico completo aninhado
        MedicoResponse medico,
        // retorna o paciente completo aninhado
        PacienteResponse paciente
) {
    public static ConsultaResponse from(Consulta consulta) {
        return new ConsultaResponse(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getStatus(),
                consulta.getObservacao(),
                // converte Medico em MedicoResponse
                MedicoResponse.from(consulta.getMedico()),
                // converte Paciente em PacienteResponse
                PacienteResponse.from(consulta.getPaciente())
        );
    }
}
