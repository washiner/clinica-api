package com.washiner.clinica_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "consultorios")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // número do consultório ex: 101, 202
    @Column(nullable = false)
    private Integer numero;

    // andar do consultório ex: 1, 2, 3
    @Column(nullable = false)
    private Integer andar;

    // cada consultório pertence a um único médico
    // e cada médico tem um único consultório
    @OneToOne
    @JoinColumn(name = "medico_id", unique = true)
    private Medico medico;
    // unique = true garante que nenhum médico
    // tenha dois consultórios ao mesmo tempo
}