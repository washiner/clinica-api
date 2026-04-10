package com.washiner.clinica_api.model;

import com.washiner.clinica_api.enums.StatusConsulta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // data e hora da consulta
    // LocalDateTime guarda data e hora juntos
    // ex: 2026-04-10T14:30:00
    @Column(nullable = false)
    private LocalDateTime dataHora;

    // status atual da consulta
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusConsulta status;

    // observações opcionais do médico
    // nullable = true pois não é obrigatório
    @Column(length = 500)
    private String observacao;

    // primeiro @ManyToOne — consulta pertence a um médico
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    // segundo @ManyToOne — consulta pertence a um paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;
}
