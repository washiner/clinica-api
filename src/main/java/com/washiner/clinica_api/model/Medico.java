package com.washiner.clinica_api.model;

import com.washiner.clinica_api.enums.TipoContrato;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    // crm é único — cada médico tem o seu
    @Column(nullable = false, unique = true, length = 20)
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoContrato tipoContrato;

    // true = médico ativo / false = inativo
    private Boolean ativo;

    // aqui está o @ManyToMany
    // um médico tem várias especialidades
    // uma especialidade pertence a vários médicos
    // o JPA cria a tabela medicos_especialidades automaticamente
    @ManyToMany
    @JoinTable(
            name = "medicos_especialidades",           // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "medico_id"),          // coluna do lado do Médico
            inverseJoinColumns = @JoinColumn(name = "especialidade_id") // coluna do lado da Especialidade
    )
    private List<Especialidade> especialidades = new ArrayList<>();
}