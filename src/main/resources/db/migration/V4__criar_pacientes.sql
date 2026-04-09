CREATE TABLE pacientes
(
    id             BIGSERIAL PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    cpf            VARCHAR(14)  NOT NULL UNIQUE,
    email          VARCHAR(150) NOT NULL UNIQUE,
    telefone       VARCHAR(20)  NOT NULL,
    tipo_sanguineo VARCHAR(20)  NOT NULL,
    ativo          BOOLEAN      NOT NULL DEFAULT TRUE
);