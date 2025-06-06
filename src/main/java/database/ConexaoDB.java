package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    //Estabelece conexão com o banco de dados, a ser usado pelos DAO
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/controle_clientes_a3?useSSL=false&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String senha = "1234";

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    //Finaliza conexão com o banco de dados
    public static void desconectar(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
