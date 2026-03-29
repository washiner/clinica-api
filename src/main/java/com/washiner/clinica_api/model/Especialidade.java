package com.washiner.clinica_api.model;

import com.washiner.clinica_api.enums.TipoEspecialidade;
import jakarta.persistence.*;
import lombok.*;

@Entity                              // diz pro JPA que essa classe é uma tabela no banco
@Getter                              // Lombok gera todos os getters automaticamente
@Setter                              // Lombok gera todos os setters automaticamente
@ToString                            // Lombok gera o toString() — útil pra debug no log
@NoArgsConstructor                   // Lombok gera construtor vazio — obrigatório pro JPA
@AllArgsConstructor                  // Lombok gera construtor com todos os campos — usado pelo @Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Lombok gera equals e hashCode
// onlyExplicitlyIncluded = true significa que
// só usa os campos marcados com @EqualsAndHashCode.Include
// evita comparar campos desnecessários
@Builder                             // Lombok permite criar objetos assim:
// Especialidade.builder().nome("Cardiologia").build()
// mais legível que setar campo por campo
@Table(name = "especialidades")       // define o nome da tabela no banco
public class Especialidade {

    @Id                                                    // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // banco gera o id automaticamente
    @EqualsAndHashCode.Include                             // usa SÓ o id pra comparar dois objetos
    // duas especialidades são iguais se tiverem
    // o mesmo id, independente do nome ou tipo
    private Long id;

    @Column(nullable = false, length = 100)  // coluna obrigatória com máximo 100 caracteres
    private String nome;                     // nome da especialidade ex: "Cardiologia"

    @Enumerated(EnumType.STRING)             // salva o enum como texto no banco ex: "CARDIOLOGIA"
    @Column(nullable = false, length = 50)   // coluna obrigatória com máximo 50 caracteres
    private TipoEspecialidade tipo;          // tipo baseado no enum TipoEspecialidade

    private Boolean ativa;                   // true = especialidade ativa / false = inativa
    // começa como true no Service na hora de criar
}
