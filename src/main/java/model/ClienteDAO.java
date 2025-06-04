package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirCliente(Cliente cliente) {
        String sqlInsert = "INSERT INTO Cliente (nome, telefone, uf, cep," +
                "complemento, cpf, numero_processo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sqlInsert)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getUf());
            stmt.setString(4, cliente.getCep());
            stmt.setString(5, cliente.getComplemento());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getNumeroProcesso());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }

        System.out.println("Cliente cadastrado com sucesso");
    }

    public Cliente buscarClientePorId (int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("uf"),
                        rs.getString("cep"),
                        rs.getString("complemento"),
                        rs.getString("cpf"),
                        rs.getString("numero_processo"),
                        rs.getInt("status_cliente"),
                        rs.getTimestamp("data_cadastro").toLocalDateTime()
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
        }
        return null;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = """
            UPDATE Cliente SET
                nome = ?,
                telefone = ?,
                uf = ?,
                cep = ?,
                complemento = ?,
                cpf = ?,
                numero_processo = ?,
                status_cliente = ?
            WHERE id = ?
        """;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getUf());
            stmt.setString(4, cliente.getCep());
            stmt.setString(5, cliente.getComplemento());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getNumeroProcesso());
            stmt.setInt(8, cliente.getStatusCliente());
            stmt.setInt(9, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }

        System.out.println("Cliente atualizado com sucesso");
    }
}
