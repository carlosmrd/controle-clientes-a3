package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializadorDB {

    public static void inicializar() {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String senha = "1234";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conexao.createStatement()) {

            String sqlCriarDB = "CREATE DATABASE IF NOT EXISTS controle_clientes_a3";
            stmt.executeUpdate(sqlCriarDB);
            System.out.println("Banco de dados 'controle_clientes_a3' verificado/criado.");

            stmt.execute("USE controle_clientes_a3");

            String sqlCriarTabela = """
                    CREATE TABLE IF NOT EXISTS StatusCliente(
                        codigo INT PRIMARY KEY,
                        descricao_status VARCHAR(30) NOT NULL
                    )
                    """;
            stmt.executeUpdate(sqlCriarTabela);
            System.out.println("Tabela 'StatusCliente' verificada/criada.");

            String sqlAtualizarTabela = """
                    INSERT IGNORE INTO StatusCliente (codigo, descricao_status) VALUES
                        (1, 'Atendimento inicial'),
                        (2, 'Agendar reunião'),
                        (3, 'Realizar reunião'),
                        (4, 'Negociar honorários'),
                        (5, 'Honorários acordados')
                    """;
            stmt.executeUpdate(sqlAtualizarTabela);
            System.out.println("Dados da tabela 'StatusCliente' verificados/criados.");

            sqlCriarTabela = """
                    CREATE TABLE IF NOT EXISTS Cliente(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nome VARCHAR(100) NOT NULL,
                        telefone CHAR(11) NOT NULL,
                        uf CHAR(2) NOT NULL CHECK (uf IN ('AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO',
                                                    'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI',
                                                    'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO')),
                        cep VARCHAR(8),
                        complemento VARCHAR(150),
                        cpf CHAR(11) UNIQUE,
                        numero_processo VARCHAR(20),
                        status_cliente INT NOT NULL DEFAULT 1,
                        data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_cliente_status_cliente
                        FOREIGN KEY (status_cliente) REFERENCES StatusCliente(codigo)
                    )
                    """;
            stmt.executeUpdate(sqlCriarTabela);
            System.out.println("Tabela 'Cliente' verificada/criada.");

            sqlCriarTabela = """
                    CREATE TABLE IF NOT EXISTS Anotacao(
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        id_cliente INT NOT NULL,
                        descricao_anotacao TEXT NOT NULL,
                        data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_anotacao_id_cliente
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id) ON DELETE CASCADE
                    )
                    """;
            stmt.executeUpdate(sqlCriarTabela);
            System.out.println("Tabela 'Anotacao' verificada/criada.");

            sqlCriarTabela = """
                    CREATE TABLE IF NOT EXISTS Lembrete (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        id_cliente INT NOT NULL,
                        data_hora DATETIME NOT NULL,
                        descricao_lembrete VARCHAR(255),
                        CONSTRAINT fk_lembrete_id_cliente
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id) ON DELETE CASCADE
                    )
                    """;
            stmt.executeUpdate(sqlCriarTabela);
            System.out.println("Tabela 'Lembrete' verificada/criada.");

        } catch (SQLException e) {
            System.out.println("Erro ao inicializar o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
