# **V2 Sistema de Cadastro - API de Gerenciamento de Usuários**

Este projeto consiste em uma API REST para o gerenciamento de usuários, desenvolvida com o objetivo de aplicar padrões de arquitetura modernos e as versões mais recentes do ecossistema Java. A aplicação foca em segurança de dados, validações robustas e documentação automatizada.

### **Tecnologias Utilizadas**

Java 21: Utilização de Records para modelos de dados imutáveis.

Spring Boot 4.0.5: Base para o desenvolvimento da infraestrutura e serviços.

Spring Data JPA: Implementação da camada de persistência.

PostgreSQL: Banco de dados relacional utilizado para armazenamento dos dados.

Bean Validation (Jakarta): Camada de validação de integridade dos dados de entrada.

SpringDoc OpenAPI (Swagger): Geração automática da documentação técnica e interface de testes.

### **Diferenciais Técnicos e Arquitetura**

Padrão DTO (Data Transfer Object): Implementado para isolar as entidades do banco de dados da camada de resposta, garantindo que informações sensíveis, como senhas, não sejam trafegadas nas requisições de saída.

Tratamento Global de Exceções: Uso da anotação @ControllerAdvice para centralizar a captura de erros, retornando respostas padronizadas no formato JSON através da classe StandardError.

Conversão de Tipos e Formatação: Configuração de desserialização personalizada para datas no padrão brasileiro (dd/MM/yyyy) utilizando anotações do Jackson.

Integridade de Negócio: Verificação programática de e-mails duplicados e validações temporais para datas de nascimento.

### **Documentação da API**

A documentação interativa detalhando todos os endpoints, parâmetros necessários e modelos de resposta está disponível via Swagger UI. Para acessar, certifique-se de que a aplicação está em execução e utilize o endereço abaixo:

http://localhost:8080/swagger-ui/index.html

### Instruções de Instalação e Execução

#### Configuração do Banco de Dados:

Certifique-se de possuir uma instância do PostgreSQL ativa. Crie o banco de dados conforme as credenciais definidas no arquivo application.properties do projeto.

#### Clonagem do Repositório:

git clone https://github.com/NicollasMassu/Sistema-Cadastro-V2.git

#### Build e Execução:

Abra o projeto em um ambiente de desenvolvimento compatível com Maven (como IntelliJ IDEA), realize o download das dependências e execute a classe principal V2CadastroApplication.

**Desenvolvido por: Nicollas Massu**

[LinkedIn](https://www.linkedin.com/in/nicollasmassu/?skipRedirect=true) | [E-mail](nicollasmassu@gmail.com)