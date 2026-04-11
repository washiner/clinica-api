package com.washiner.clinica_api.repository;

import com.washiner.clinica_api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // busca todos os médicos com paginação
    // o Spring implementa esse método automaticamente
    // só de você declarar aqui
    Page<Medico> findAll(Pageable pageable);
}