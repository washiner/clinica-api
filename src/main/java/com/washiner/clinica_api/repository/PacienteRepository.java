package com.washiner.clinica_api.repository;

import com.washiner.clinica_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository
        extends JpaRepository<Paciente, Long> {
}
