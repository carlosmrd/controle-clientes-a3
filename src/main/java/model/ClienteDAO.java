package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
    }
}
