package com.washiner.clinica_api.service;

import com.washiner.clinica_api.dto.EspecialidadeRequest;
import com.washiner.clinica_api.dto.EspecialidadeResponse;
import com.washiner.clinica_api.exception.EntidadeNaoEncontradaException;
import com.washiner.clinica_api.model.Especialidade;
import com.washiner.clinica_api.repository.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    // cria uma nova especialidade
    public EspecialidadeResponse criar(EspecialidadeRequest request) {
        var especialidade = new Especialidade();
        especialidade.setNome(request.nome());
        especialidade.setTipo(request.tipo());
        especialidade.setAtiva(true); // sempre começa ativa

        return EspecialidadeResponse.from(
                especialidadeRepository.save(especialidade)
        );
    }

    // busca especialidade pelo id
    public EspecialidadeResponse buscarPorId(Long id) {
        var especialidade = especialidadeRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Especialidade não encontrada com id: " + id
                ));
        return EspecialidadeResponse.from(especialidade);
    }

    // lista todas as especialidades
    public List<EspecialidadeResponse> listar() {
        return especialidadeRepository.findAll()
                .stream()
                .map(EspecialidadeResponse::from)
                .toList();
    }
}
