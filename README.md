# Clinica API

API REST para gerenciamento de uma clínica médica.
Desenvolvida com Java e Spring Boot para praticar
relacionamentos JPA, paginação e boas práticas.

---

## Tecnologias

- Java 25
- Spring Boot 4
- PostgreSQL 16
- Flyway
- Lombok
- Swagger / OpenAPI
- Docker

---

## Como rodar

### Pré-requisitos
- Docker instalado
- Java 25

### Passo a passo

1. Clone o repositório
2. Suba o banco
```bash
docker-compose up -d
```
3. Rode a aplicação pela IDE
4. Acesse o Swagger
```
http://localhost:8080/swagger-ui/index.html
```

---

## Endpoints

### Especialidades

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /v1/especialidades | Cadastra uma especialidade |
| GET | /v1/especialidades | Lista todas as especialidades |
| GET | /v1/especialidades/{id} | Busca especialidade por id |

---

## Status do projeto

Em desenvolvimento — novos endpoints sendo adicionados.

---

## Autor

Washiner Takeuchi