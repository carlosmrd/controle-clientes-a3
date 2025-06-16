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

- Java 24
- JDBC (conexão com banco de dados)
- MySQL (versão 8 ou compatível)
- IDE de sua preferência (Eclipse, IntelliJ, NetBeans, etc.)

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
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2. Configurar a Conexão com o Banco

Atualize as classes `ConexaoDB.java` e `InicializadorDB.java` com os seus dados de acesso:

- `String url = "jdbc:mysql://localhost:3306/nome_do_banco";`
- `String usuario = "seu_usuario";`
- `String senha = "sua_senha";`

A classe `InicializadorDB.java` irá criar o banco de dados conforme as necessidades do programa na primeira execução.

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

- Augusto (AugustoPavao7)
- Carlos (carlosmrd)
- Lucas
- Keven (KevenKovu)