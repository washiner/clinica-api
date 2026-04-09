package com.washiner.clinica_api.model;

import com.washiner.clinica_api.enums.TipoSanguineo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // nome completo do paciente
    @Column(nullable = false, length = 100)
    private String nome;

    // cpf único — não pode ter dois pacientes com o mesmo cpf
    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    // email único — não pode ter dois pacientes com o mesmo email
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    // telefone para contato
    @Column(nullable = false, length = 20)
    private String telefone;

    // tipo sanguíneo baseado no enum
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoSanguineo tipoSanguineo;

    // true = paciente ativo / false = inativo
    @Column(nullable = false)
    private Boolean ativo;
}
