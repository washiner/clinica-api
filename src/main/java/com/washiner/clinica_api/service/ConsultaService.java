package com.washiner.clinica_api.service;

import com.washiner.clinica_api.dto.ConsultaRequest;
import com.washiner.clinica_api.dto.ConsultaResponse;
import com.washiner.clinica_api.enums.StatusConsulta;
import com.washiner.clinica_api.exception.EntidadeNaoEncontradaException;
import com.washiner.clinica_api.model.Consulta;
import com.washiner.clinica_api.repository.ConsultaRepository;
import com.washiner.clinica_api.repository.MedicoRepository;
import com.washiner.clinica_api.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaResponse criar(ConsultaRequest request) {

        // busca o médico pelo id informado
        var medico = medicoRepository.findById(request.medicoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Médico não encontrado com id: " + request.medicoId()
                ));

        // busca o paciente pelo id informado
        var paciente = pacienteRepository.findById(request.pacienteId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Paciente não encontrado com id: " + request.pacienteId()
                ));

        // monta a consulta com médico e paciente
        var consulta = Consulta.builder()
                .dataHora(request.dataHora())
                .status(StatusConsulta.AGENDADA) // sempre começa agendada
                .observacao(request.observacao())
                .medico(medico)
                .paciente(paciente)
                .build();

        return ConsultaResponse.from(
                consultaRepository.save(consulta)
        );
    }

    public ConsultaResponse buscarPorId(Long id) {
        var consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Consulta não encontrada com id: " + id
                ));
        return ConsultaResponse.from(consulta);
    }

    public List<ConsultaResponse> listar() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaResponse::from)
                .toList();
    }
}