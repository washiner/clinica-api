package com.washiner.clinica_api.service;

import com.washiner.clinica_api.dto.ConsultorioRequest;
import com.washiner.clinica_api.dto.ConsultorioResponse;
import com.washiner.clinica_api.exception.EntidadeNaoEncontradaException;
import com.washiner.clinica_api.model.Consultorio;
import com.washiner.clinica_api.repository.ConsultorioRepository;
import com.washiner.clinica_api.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;
    private final MedicoRepository medicoRepository;

    public ConsultorioResponse criar(ConsultorioRequest request) {

        // busca o médico pelo id informado
        var medico = medicoRepository.findById(request.medicoId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Médico não encontrado com id: " + request.medicoId()
                ));

        // monta o consultório com o médico
        var consultorio = Consultorio.builder()
                .numero(request.numero())
                .andar(request.andar())
                .medico(medico)
                .build();

        return ConsultorioResponse.from(
                consultorioRepository.save(consultorio)
        );
    }

    public ConsultorioResponse buscarPorId(Long id) {
        var consultorio = consultorioRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Consultório não encontrado com id: " + id
                ));
        return ConsultorioResponse.from(consultorio);
    }

    public List<ConsultorioResponse> listar() {
        return consultorioRepository.findAll()
                .stream()
                .map(ConsultorioResponse::from)
                .toList();
    }
}