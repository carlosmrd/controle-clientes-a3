# Sistema de Gerenciamento de Clientes - Escritório Jurídico

Este projeto é um **trabalho acadêmico** desenvolvido para fins de aprendizado e representa o projeto da avaliação A3 de Programação de Soluções Computacionais da FASEH.

## Sobre o Projeto

O sistema tem como objetivo auxiliar escritórios jurídicos no controle de **clientes**, **anotações** e **lembretes** associados a processos jurídicos. O projeto inclui funcionalidades para:

- Cadastro, busca, listagem, alteração e exclusão de clientes.
- Criação e listagem de anotações vinculadas a clientes.
- Criação e listagem de lembretes agendados por data/hora.
- Uso de menus interativos para navegação no terminal.
- Integração com banco de dados relacional (MySQL).

---

## Requisitos do Sistema

### Tecnologias Utilizadas

- [Java 24](https://www.oracle.com/br/java/technologies/downloads/) (linguagem principal usada para o desenvolvimento da aplicação)
- Maven (ferramenta de automação de build e gerenciamento de dependências)
- [MySQL 8](https://www.mysql.com/downloads/) (banco de dados relacional utilizado para armazenar os dados dos clientes, anotações e lembretes)
- JDBC (Java Database Connectivity — utilizado para conectar a aplicação Java ao banco de dados MySQL)
- IDE de sua preferência ([Eclipse](https://eclipseide.org/), [IntelliJ](https://www.jetbrains.com/idea/download/?section=windows), [NetBeans](https://netbeans.apache.org/front/main/download/), etc.)

### Estrutura do Banco de Dados

O banco de dados inclui as seguintes tabelas:

- `Cliente`
- `StatusCliente` (tabela de apoio com descrições de status)
- `Anotacao`
- `Lembrete`

Scripts de criação do banco e das tabelas fazem parte da classe InicializadorDB.java.

---

##  Como Usar

### 1. Clonar o Repositório

```bash
git clone https://github.com/carlosmrd/controle-clientes-a3.git
cd controle-clientes-a3
```

### 2. Configurar a Conexão com o Banco

Atualize as classes `ConexaoDB.java` e `InicializadorDB.java` com os seus dados de acesso:

- `String url = "jdbc:mysql://localhost:3306/nome_do_banco";`
- `String usuario = "seu_usuario";`
- `String senha = "sua_senha";`

A classe `InicializadorDB.java` irá criar o banco de dados conforme as necessidades do programa na primeira execução.

Caso queira, o diretório `/sql` inclui um script para inserir diversos clientes, anotações e lembretes fictícios, que podem ser usados para testes. É importante inciar o programa ao menos uma vez antes de usar o script.

### 3. Compilar e Executar

Compile e execute a classe Main.java. O programa será iniciado com menus interativos no terminal.

---

## Funcionalidades

### Cliente

- Cadastrar novo cliente

- Buscar cliente por ID

- Listar todos os clientes

- Alterar dados de cliente

- Excluir cliente

### Anotações

- Criar anotação vinculada a cliente

- Listar anotações de um cliente

### Lembretes

- Criar lembrete com data e hora

- Listar lembretes futuros ordenados por data/hora

---

## Aviso

Este projeto é de caráter educacional e foi desenvolvido como um trabalho acadêmico para a entrega A3 da disciplina de Programação de Soluções Computacionais do primeiro semestre de 2025 na FASEH. O mesmo não deve ser utilizado sem devidas adaptações e validações de segurança.

### Integrantes

- Augusto ([AugustoPavao7](https://github.com/augustopavao7))
- Carlos ([carlosmrd](https://github.com/carlosmrd))
- Lucas
- Keven ([KevenKovu](https://github.com/KevenKovu))