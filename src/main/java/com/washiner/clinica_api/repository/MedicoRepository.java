package com.washiner.clinica_api.repository;

import com.washiner.clinica_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}