package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class LembreteDAO {

    private Connection conexao;

    //Construtor para o DAO, recebe a conexão instanciada no Main
    public LembreteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Insere os atributos de um objeto Lembrete e o id de um objeto cliente como linha na tabela Anotacao
    public void criarLembrete(Lembrete lembrete) {
        String sql = """
            INSERT INTO Lembrete (
                id_cliente,
                descricao_anotacao,
                data_hora)
            VALUES (?, ?)
        """;

        //Cria um statement usando a String sql e os atributos de Anotacao e Cliente
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, lembrete.getIdCliente());
            stmt.setString(2, lembrete.getDescricaoLembrete());
            stmt.setTimestamp(3, Timestamp.valueOf(lembrete.getDataHora()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("\nLembrete criado com sucesso. ID do lembrete: " + id);
            }

        } catch (Exception e) {
            System.err.println("\nErro ao criar lembrete: " + e.getMessage() + "\n");
        }
    }

}
