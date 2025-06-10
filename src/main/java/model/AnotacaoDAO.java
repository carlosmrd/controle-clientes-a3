package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnotacaoDAO {

    private Connection conexao;

    //Construtor para o DAO, recebe a conexão instanciada no Main
    public AnotacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Insere os atributos de um objeto Anotacao e o id de um objeto cliente como linha na tabela Anotacao
    public void criarAnotacao(Anotacao anotacao) {
        String sql = """
            INSERT INTO Anotacao (
                id_cliente,
                descricao_anotacao)
            VALUES (?, ?)
        """;

        //Cria um statement usando a String sql e os atributos de Anotacao e Cliente
        try (PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, anotacao.getIdCliente());
            stmt.setString(2, anotacao.getDescricaoAnotacao());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("\nAnotação criada com sucesso. ID da anotação: " + id);
            }

        } catch (Exception e) {
            System.err.println("\nErro ao criar anotação: " + e.getMessage() + "\n");
        }
    }

    //Retorna um ArrayList de anotações conforme a foreign key id_cliente da tabela Anotacoes
    public ArrayList<Anotacao> buscarAnotacoes(Cliente cliente) {

        ArrayList<Anotacao> anotacoes = new ArrayList<>();

        String sql = """
            SELECT
                id,
                id_cliente,
                descricao_anotacao,
                data_hora
            FROM Anotacao
            WHERE id_cliente = ?
        """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());

            ResultSet rs = stmt.executeQuery();

            //Cria um objeto dentro do ArrayList para cada linha do banco que corresponder
            //a query até que não existam mais linhas.
            while (rs.next()) {
                anotacoes.add(new Anotacao(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("descricao_anotacao"),
                        rs.getTimestamp("data_hora").toLocalDateTime()
                ));
            }
            //Retorna o ArrayList
            return anotacoes;
        } catch (SQLException e) {
            System.err.println("\nErro ao buscar as anotações: " + e.getMessage() + "\n");
        }
        return null;
    }

    //Retorna um objeto Anotacao de acordo com uma linha na tabela Anotacao, especificada pelo ID
    public Anotacao buscarAnotacaoId(int id) {
        String sql = """
            SELECT
                id,
                id_cliente,
                descricao_anotacao,
                data_hora
            FROM Anotacao
            WHERE id = ?
        """;

        //Cria um statement usando a String sql
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            //Cria um objeto Anotacao com os dados retornados pela query
            if (rs.next()) {
                Anotacao anotacao = new Anotacao(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("descricao_anotacao"),
                        rs.getTimestamp("data_hora").toLocalDateTime()
                );
                return anotacao;
            }
        } catch (SQLException e) {
            System.err.println("\nErro ao buscar a anotação: " + e.getMessage() + "\n");
        }
        return null;
    }

    public void alterarAnotacao(Anotacao anotacao) {
        String sql = """
            UPDATE Anotacao SET
                descricao_anotacao = ?
            WHERE id = ?
        """;

        //Cria um statement usando a String sql e os atributos de Anotacao
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, anotacao.getDescricaoAnotacao());
            stmt.setInt(2, anotacao.getId());
            stmt.executeUpdate();
            System.out.println("\nAnotação atualizada com sucesso.");
        } catch (SQLException e) {
            System.err.println("\nErro ao atualizar anotação: " + e.getMessage() + "\n");
        }
    }

    public void deletarAnotacao(Anotacao anotacao) {
        String sql = "DELETE FROM Anotacao WHERE id = ?";

        //Cria um statement usando a String sql
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, anotacao.getId());
            stmt.executeUpdate();
            System.out.println("\nAnotação deletada com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar a anotação: " + e.getMessage() + "\n");
        }
    }
}
