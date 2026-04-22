package com.washiner.clinica_api.repository;

import com.washiner.clinica_api.model.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository
        extends JpaRepository<Consulta, Long> {

    // busca todas as consultas com paginação
    Page<Consulta> findAll(Pageable pageable);
}