package com.washiner.clinica_api.service;

import com.washiner.clinica_api.dto.MedicoRequest;
import com.washiner.clinica_api.dto.MedicoResponse;
import com.washiner.clinica_api.exception.EntidadeNaoEncontradaException;
import com.washiner.clinica_api.model.Medico;
import com.washiner.clinica_api.repository.EspecialidadeRepository;
import com.washiner.clinica_api.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final EspecialidadeRepository especialidadeRepository;

    public MedicoResponse criar(MedicoRequest request) {

        // busca todas as especialidades pelos ids informados
        var especialidades = especialidadeRepository
                .findAllById(request.especialidadeIds());

        // verifica se todos os ids existem no banco
        if (especialidades.size() != request.especialidadeIds().size()) {
            throw new EntidadeNaoEncontradaException(
                    "Uma ou mais especialidades não encontradas"
            );
        }

        var medico = Medico.builder()
                .nome(request.nome())
                .crm(request.crm())
                .tipoContrato(request.tipoContrato())
                .ativo(true)
                .especialidades(new ArrayList<>(especialidades))
                .build();

        return MedicoResponse.from(medicoRepository.save(medico));
    }

    public MedicoResponse buscarPorId(Long id) {
        var medico = medicoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Médico não encontrado com id: " + id
                ));
        return MedicoResponse.from(medico);
    }

    //sem a paginaçao
//    public List<MedicoResponse> listar() {
//        return medicoRepository.findAll()
//                .stream()
//                .map(MedicoResponse::from)
//                .toList();
//    }

    // agora fica assim
    public Page<MedicoResponse> listar(Pageable pageable) {
        // busca uma página de médicos no banco
        // o Pageable diz qual página e quantos por página
        return medicoRepository.findAll(pageable)
                // .map() funciona direto no Page — não precisa de stream
                .map(MedicoResponse::from);
    }
}