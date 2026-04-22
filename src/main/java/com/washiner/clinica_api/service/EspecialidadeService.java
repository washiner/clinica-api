package com.washiner.clinica_api.service;

import com.washiner.clinica_api.dto.EspecialidadeRequest;
import com.washiner.clinica_api.dto.EspecialidadeResponse;
import com.washiner.clinica_api.exception.EntidadeNaoEncontradaException;
import com.washiner.clinica_api.model.Especialidade;
import com.washiner.clinica_api.repository.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    @Transactional  // escreve no banco → precisa de transação
    public EspecialidadeResponse criar(EspecialidadeRequest request) {
        var especialidade = new Especialidade();
        especialidade.setNome(request.nome());
        especialidade.setTipo(request.tipo());
        especialidade.setAtiva(true);
        return EspecialidadeResponse.from(
                especialidadeRepository.save(especialidade)
        );
    }

    @Transactional(readOnly = true)  // só lê → otimização
    public EspecialidadeResponse buscarPorId(Long id) {
        var especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Especialidade não encontrada com id: " + id
                ));
        return EspecialidadeResponse.from(especialidade);
    }

    @Transactional(readOnly = true)  // só lê → otimização
    public List<EspecialidadeResponse> listar() {
        return especialidadeRepository.findAll()
                .stream()
                .map(EspecialidadeResponse::from)
                .toList();
    }
}
