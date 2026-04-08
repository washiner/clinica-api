package com.washiner.clinica_api.repository;

import com.washiner.clinica_api.model.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioRepository
        extends JpaRepository<Consultorio, Long> {
}