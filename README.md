# API REST - Sistema de Cadastro de Usuários

API REST desenvolvida para gerenciamento de usuários, permitindo operações completas de cadastro, consulta, atualização e exclusão de registros.

O projeto foi construído com foco em boas práticas de desenvolvimento backend, incluindo arquitetura em camadas, validação de dados, tratamento de exceções e separação entre entidades e objetos de transporte (DTO).

---

## Funcionalidades

* Criar usuário
  
* Listar todos os usuários
  
* Buscar usuário por ID
  
* Atualizar dados do usuário
  
* Remover usuário
  
* Validação de dados de entrada
  
* Tratamento global de erros
  
* Validação de regra de negócio (e-mail único)

---

## Tecnologias Utilizadas

* Java 21
  
* Spring Boot
  
* Spring Data JPA
  
* PostgreSQL
  
* Bean Validation (Jakarta)
  
* SpringDoc OpenAPI (Swagger)

---

## Arquitetura

O projeto segue o padrão de arquitetura em camadas:

* Controller: responsável por receber e responder requisições HTTP
  
* Service: responsável pelas regras de negócio e validações
  
* Repository: responsável pela comunicação com o banco de dados
  
* DTO (Data Transfer Object): responsável por transportar dados entre as camadas

---

## Diferenciais Técnicos

* Uso de DTOs com Records para imutabilidade e segurança dos dados
  
* Separação entre camada de API e entidade de banco
  
* Tratamento global de exceções com ControllerAdvice
  
* Respostas padronizadas para erros (validação, negócio e recursos não encontrados)
  
* Validação de dados com Bean Validation
  
* Regra de negócio para evitar e-mails duplicados
  
* Tratamento de erro para JSON inválido

---

## Endpoints

| Método | Endpoint    | Descrição               |
| ------ | ----------- | ----------------------- |
| GET    | /users      | Lista todos os usuários |
| GET    | /users/{id} | Busca usuário por ID    |
| POST   | /users      | Cria um novo usuário    |
| PUT    | /users/{id} | Atualiza um usuário     |
| DELETE | /users/{id} | Remove um usuário       |

---

## Exemplo de Requisição

POST /users

```json
{
  "nome": "Nicollas",
  "email": "nicollas@email.com",
  "senha": "12345678",
  "dataNascimento": "01/01/2005"
}
```

---

## Exemplo de Resposta

```json
{
  "id": 1,
  "nome": "Nicollas",
  "email": "nicollas@email.com",
  "dataNascimento": "01/01/2005"
}
```

---

## Exemplo de Erro

Usuário não encontrado:

```json
{
  "timestamp": "2026-04-22T15:00:00Z",
  "status": 404,
  "error": "Recurso não encontrado",
  "message": "Usuário não encontrado com o ID: 1"
}
```

Erro de validação:

```json
{
  "email": "E-mail inválido",
  "nome": "O nome é obrigatório"
}
```

---

## Documentação da API

A documentação interativa está disponível via Swagger:

http://localhost:8080/swagger-ui/index.html

---

## Como Executar

1. Clone o repositório

```bash
git clone https://github.com/NicollasMassu/Sistema-Cadastro-V2.git
```

2. Configure o banco de dados

Certifique-se de ter o PostgreSQL rodando e configure as credenciais no application.properties.

3. Execute a aplicação

execute a classe principal no IntelliJ.

---

## Autor

Nicollas Massu

[LinkedIn](https://www.linkedin.com/in/nicollasmassu/)
E-mail: [nicollasmassu@gmail.com](mailto:nicollasmassu@gmail.com)

---
