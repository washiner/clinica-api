# Clinica API

API REST para gerenciamento de uma clínica médica,
desenvolvida com Java e Spring Boot.

Projeto construído do zero seguindo boas práticas
de desenvolvimento — arquitetura em camadas, DTOs,
tratamento de exceções, migrations e paginação.

---

## Tecnologias

- Java 25
- Spring Boot 4
- PostgreSQL 16
- Flyway — versionamento do banco
- Lombok — redução de boilerplate
- Swagger / OpenAPI — documentação automática
- Docker — banco de dados em container

---

## Como rodar

### Pré-requisitos
- Docker instalado
- Java 25

### Passo a passo

1. Clone o repositório
```bash
git clone https://github.com/washiner/clinica-api.git
```

2. Suba o banco
```bash
docker-compose up -d
```

3. Rode a aplicação pela IDE

4. Acesse o Swagger
```
http://localhost:8080/swagger-ui/index.html
```

### Roteiro de teste — siga essa ordem

O banco começa vazio. Para testar os endpoints
siga essa sequência:

```
1. POST /v1/especialidades
2. POST /v1/medicos       (usa id da especialidade)
3. POST /v1/consultorios  (usa id do médico)
4. POST /v1/pacientes
5. POST /v1/consultas     (usa id do médico e do paciente)
```

---

## Endpoints

### Especialidades

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /v1/especialidades | Cadastra uma especialidade |
| GET | /v1/especialidades | Lista todas as especialidades |
| GET | /v1/especialidades/{id} | Busca especialidade por id |

### Médicos

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /v1/medicos | Cadastra um médico |
| GET | /v1/medicos | Lista médicos com paginação |
| GET | /v1/medicos/{id} | Busca médico por id |

### Consultórios

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /v1/consultorios | Cadastra um consultório |
| GET | /v1/consultorios | Lista todos os consultórios |
| GET | /v1/consultorios/{id} | Busca consultório por id |

### Pacientes

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /v1/pacientes | Cadastra um paciente |
| GET | /v1/pacientes | Lista todos os pacientes |
| GET | /v1/pacientes/{id} | Busca paciente por id |

### Consultas

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /v1/consultas | Agenda uma consulta |
| GET | /v1/consultas | Lista consultas com paginação |
| GET | /v1/consultas/{id} | Busca consulta por id |

---

## Decisões de arquitetura

**DTOs com Record** — o model nunca é exposto
diretamente na resposta da API. Todo dado que
entra e sai passa por um DTO.

**Flyway Migrations** — o banco é versionado.
Nenhuma tabela é criada pelo Hibernate
automaticamente — tudo passa pelo Flyway.

**Arquitetura em camadas** — Controller chama
Service, Service chama Repository. Nenhuma
camada conhece a camada acima dela.

**Tratamento de exceções centralizado** — o
GlobalExceptionHandler captura todos os erros
e devolve respostas padronizadas com status
e mensagem.

**@Transactional** — métodos de escrita usam
@Transactional e métodos de leitura usam
@Transactional(readOnly = true) para otimização.

**Paginação** — listagem de médicos e consultas
usa Pageable com ordenação configurável.

---

## Relacionamentos implementados

```
Medico (N) ──── (N) Especialidade   @ManyToMany
Medico (1) ──── (1) Consultorio     @OneToOne
Medico (1) ──── (N) Consulta        @ManyToOne
Paciente (1) ── (N) Consulta        @ManyToOne
```

---

## O que foi feito

- [x] CRUD de Especialidades
- [x] CRUD de Médicos com múltiplas especialidades
- [x] CRUD de Consultórios vinculados a médicos
- [x] CRUD de Pacientes
- [x] Agendamento de Consultas
- [x] Paginação e ordenação
- [x] Tratamento global de exceções
- [x] Documentação com Swagger
- [x] Versionamento do banco com Flyway
- [x] Docker para banco de dados

## O que vem a seguir

- [ ] Autenticação JWT
- [ ] Testes unitários com JUnit e Mockito
- [ ] Upload de arquivos
- [ ] Rate limiting
- [ ] WebSocket

---

## Autor

Washiner Takeuchi
[GitHub](https://github.com/washiner)
[LinkedIn](https://www.linkedin.com/in/washiner-takeuchi)