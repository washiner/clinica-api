package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.TipoSanguineo;
import com.washiner.clinica_api.model.Paciente;

public record PacienteResponse(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        TipoSanguineo tipoSanguineo,
        Boolean ativo
) {
    public static PacienteResponse from(Paciente paciente) {
        return new PacienteResponse(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getTipoSanguineo(),
                paciente.getAtivo()
        );
    }
}