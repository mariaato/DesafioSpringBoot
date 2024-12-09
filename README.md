### 🙍Sistema de Gestão de Entidades com Spring Boot 

## 🚀Descrição

O Sistema de Gestão de Entidades é uma aplicação em Java construída com o Spring Boot que implementa operações CRUD (Create, Read, Update, Delete). Ela foi desenvolvida com foco em boas práticas, incluindo separação de responsabilidades por camadas e uso de tecnologias modernas, como o Hibernate para ORM.


## 🎯 Objetivos
- Implementar operações CRUD básicas.
- Seguir padrões de arquitetura em camadas (Controller, Service, Repository).
- Utilizar Hibernate para mapeamento de entidades.
- Garantir validação de dados para evitar inconsistências no banco.


## 📋 Pré-requisitos

Antes de executar o projeto, você precisará ter os seguintes requisitos instalados:

- Java 17 ou superior (recomendado)
- Maven
- IDE (opcional): Recomenda-se o uso de uma IDE como IntelliJ IDEA, Eclipse, ou VSCode para facilitar o desenvolvimento.
- PostgreSQL
- 
## 📋 Requisitos Funcionais Implementados
- Cadastro de Entidades: Permite o registro de novas entidades no sistema.
- Listagem Geral: Exibe todas as entidades cadastradas.
- Consulta por ID: Busca por entidades utilizando seu identificador único.
- Atualização de Dados: Atualiza informações de entidades já cadastradas.
- Remoção de Registros: Remove entidades do sistema com base no ID.


### 🛠 Requisitos Técnicos Atendidos
#### Frameworks:
- Spring Boot 3.x
- Hibernate 6.x
#### Banco de Dados:
- PostgreSQL
- Arquitetura em camadas:
   - Controller: Manipula requisições HTTP e envia respostas.
   - Service: Implementa lógica de negócios.
   - Repository: Gerencia a persistência no banco de dados.
- Modelo de dados:
   - id (Long) - Identificador único.
   - nome (String) - Nome da entidade.
   - dataCriacao (LocalDateTime) - Data de criação do registro.



### 🔧 Instalação

 #### 1. Clonar o Repositório
   Primeiro, clone o repositório para sua máquina local utilizando o seguinte comando:

```
git clone https://github.com/mariaato/DesafioSpringBoot

```
 #### 2. Navegar para o diretório do projeto
 ```
cd DesafioSpringBoot

```
### 3. Instalar as dependências
  Execute o seguinte comando para instalar as dependências:
    
 ```
mvn clean install

```

### 🏃‍♀️Execução

 ```
mvn spring-boot:run

```
