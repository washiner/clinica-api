package com.washiner.clinica_api.service;

import com.washiner.clinica_api.dto.PacienteRequest;
import com.washiner.clinica_api.dto.PacienteResponse;
import com.washiner.clinica_api.exception.EntidadeNaoEncontradaException;
import com.washiner.clinica_api.model.Paciente;
import com.washiner.clinica_api.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteResponse criar(PacienteRequest request) {

        // monta o paciente com os dados do request
        var paciente = Paciente.builder()
                .nome(request.nome())
                .cpf(request.cpf())
                .email(request.email())
                .telefone(request.telefone())
                .tipoSanguineo(request.tipoSanguineo())
                .ativo(true) // sempre começa ativo
                .build();

        return PacienteResponse.from(
                pacienteRepository.save(paciente)
        );
    }

    public PacienteResponse buscarPorId(Long id) {
        var paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Paciente não encontrado com id: " + id
                ));
        return PacienteResponse.from(paciente);
    }

    public List<PacienteResponse> listar() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteResponse::from)
                .toList();
    }
}