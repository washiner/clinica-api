CREATE TABLE consultas
(
    id          BIGSERIAL PRIMARY KEY,
    data_hora   TIMESTAMP   NOT NULL,
    status      VARCHAR(20) NOT NULL,
    observacao  VARCHAR(500),
    medico_id   BIGINT      NOT NULL REFERENCES medicos (id),
    paciente_id BIGINT      NOT NULL REFERENCES pacientes (id)
);