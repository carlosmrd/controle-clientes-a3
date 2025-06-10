package model;

import java.sql.*;
import java.util.ArrayList;

public class LembreteDAO {

    private Connection conexao;

    //Construtor para o DAO, recebe a conexão instanciada no Main
    public LembreteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Insere os atributos de um objeto Lembrete e o id de um objeto cliente como linha na tabela Lembrete
    public void criarLembrete(Lembrete lembrete) {
        String sql = """
            INSERT INTO Lembrete (
                id_cliente,
                descricao_lembrete,
                data_hora)
            VALUES (?, ?, ?)
        """;

        //Cria um statement usando a String sql e os atributos de Lembrete e Cliente
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

    //Retorna um ArrayList de lembretes conforme a foreign key id_cliente da tabela Lembretes
    //selecionando onde o campo data_hora for maior que a data atual, de modo a não exibir lembretes antigos
    public ArrayList<Lembrete> listarLembretes() {

        ArrayList<Lembrete> lembretes = new ArrayList<>();

        String sql = """
            SELECT
                id,
                id_cliente,
                descricao_lembrete,
                data_hora
            FROM Lembrete
            WHERE data_hora > CURRENT_DATE
            ORDER BY data_hora ASC
        """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            //Cria um objeto dentro do ArrayList para cada linha do banco que corresponder
            //a query até que não existam mais linhas.
            while (rs.next()) {
                lembretes.add(new Lembrete(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("descricao_lembrete"),
                        rs.getTimestamp("data_hora").toLocalDateTime()
                ));
            }
            //Retorna o ArrayList
            return lembretes;
        } catch (SQLException e) {
            System.err.println("\nErro ao buscar os lembretes: " + e.getMessage() + "\n");
        }
        return null;
    }

    //Retorna um ArrayList de lembretes conforme a foreign key id_cliente da tabela Lembretes
    public ArrayList<Lembrete> buscarLembretes(Cliente cliente) {

        ArrayList<Lembrete> lembretes = new ArrayList<>();

        String sql = """
            SELECT
                id,
                id_cliente,
                descricao_lembrete,
                data_hora
            FROM Lembrete
            WHERE id_cliente = ?
        """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());

            ResultSet rs = stmt.executeQuery();

            //Cria um objeto dentro do ArrayList para cada linha do banco que corresponder
            //a query até que não existam mais linhas.
            while (rs.next()) {
                lembretes.add(new Lembrete(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("descricao_lembrete"),
                        rs.getTimestamp("data_hora").toLocalDateTime()
                ));
            }
            //Retorna o ArrayList
            return lembretes;
        } catch (SQLException e) {
            System.err.println("\nErro ao buscar os lembretes: " + e.getMessage() + "\n");
        }
        return null;
    }

    public Lembrete buscarLembreteId(int id) {
        String sql = """
            SELECT
                id,
                id_cliente,
                descricao_lembrete,
                data_hora
            FROM Lembrete
            WHERE id = ?
        """;

        //Cria um statement usando a String sql
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            //Cria um objeto Lembrete com os dados retornados pela query
            if (rs.next()) {
                Lembrete lembrete = new Lembrete(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("descricao_lembrete"),
                        rs.getTimestamp("data_hora").toLocalDateTime()
                );
                return lembrete;
            }
        } catch (SQLException e) {
            System.err.println("\nErro ao buscar o lembrete: " + e.getMessage() + "\n");
        }
        return null;
    }

    public void alterarLembrete(Lembrete lembrete) {
        String sql = """
            UPDATE Lembrete SET
                descricao_lembrete = ?,
                data_hora = ?
            WHERE id = ?
        """;

        //Cria um statement usando a String sql e os atributos de Lembrete
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, lembrete.getDescricaoLembrete());
            stmt.setTimestamp(2, Timestamp.valueOf(lembrete.getDataHora()));
            stmt.setInt(3, lembrete.getId());
            stmt.executeUpdate();
            System.out.println("\nLembrete atualizado com sucesso.");
        } catch (SQLException e) {
            System.err.println("\nErro ao atualizar lembrete: " + e.getMessage() + "\n");
        }
    }

    public void deletarLembrete(Lembrete lembrete) {
        String sql = "DELETE FROM Lembrete WHERE id = ?";

        //Cria um statement usando a String sql
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, lembrete.getId());
            stmt.executeUpdate();
            System.out.println("\nLembrete deletado com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar o lembrete: " + e.getMessage() + "\n");
        }
    }
}
