package com.washiner.clinica_api.repository;

import com.washiner.clinica_api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository
        extends JpaRepository<Consulta, Long> {
}