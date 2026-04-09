package com.washiner.clinica_api.dto;

import com.washiner.clinica_api.enums.TipoSanguineo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteRequest(

        // nome obrigatório
        @NotBlank
        String nome,

        // cpf obrigatório — validação de formato
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
                message = "CPF deve estar no formato 000.000.000-00")
        String cpf,

        // email obrigatório e válido
        @NotBlank
        @Email
        String email,

        // telefone obrigatório
        @NotBlank
        String telefone,

        // tipo sanguíneo obrigatório
        @NotNull
        TipoSanguineo tipoSanguineo
) {}
