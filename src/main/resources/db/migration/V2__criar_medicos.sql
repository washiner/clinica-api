CREATE TABLE medicos
(
    id            BIGSERIAL PRIMARY KEY,
    nome          VARCHAR(100) NOT NULL,
    crm           VARCHAR(20)  NOT NULL UNIQUE,
    tipo_contrato VARCHAR(20)  NOT NULL,
    ativo         BOOLEAN      NOT NULL DEFAULT TRUE
);

CREATE TABLE medicos_especialidades
(
    medico_id        BIGINT NOT NULL REFERENCES medicos (id),
    especialidade_id BIGINT NOT NULL REFERENCES especialidades (id),
    PRIMARY KEY (medico_id, especialidade_id)
);