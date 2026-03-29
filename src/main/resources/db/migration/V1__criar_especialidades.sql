CREATE TABLE especialidades
(
    id    BIGSERIAL PRIMARY KEY,
    nome  VARCHAR(100) NOT NULL,
    tipo  VARCHAR(50)  NOT NULL,
    ativa BOOLEAN      NOT NULL DEFAULT TRUE
);