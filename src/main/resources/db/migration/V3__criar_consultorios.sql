CREATE TABLE consultorios
(
    id        BIGSERIAL PRIMARY KEY,
    numero    INTEGER NOT NULL,
    andar     INTEGER NOT NULL,
    medico_id BIGINT  NOT NULL UNIQUE REFERENCES medicos (id)
);