package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection conexao;

    //Construtor para o DAO, recebe a conexão instanciada no Main
    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Insere os atributos de um objeto Cliente como linha na tabela Cliente
    public void cadastrarCliente(Cliente cliente) {
        String sql = """
            INSERT INTO Cliente (
                nome,
                telefone,
                uf,
                cep,
                complemento,
                cpf,
                numero_processo)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        //Cria um statement usando a String sql e os atributos de Cliente
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getUf());
            stmt.setString(4, cliente.getCep());
            stmt.setString(5, cliente.getComplemento());
            stmt.setString(6, cliente.getCpf());
            stmt.setString(7, cliente.getNumeroProcesso());
            stmt.executeUpdate();
            System.out.println("\nCliente cadastrado com sucesso.");
        } catch (Exception e) {
            System.err.println("\nErro ao cadastrar o cliente: " + e.getMessage() + "\n");
        }
    }

    //Retorna um objeto Cliente de acordo com uma linha na tabela Cliente, especificada pelo ID
    public Cliente buscarClientePorId (int id) {
        String sql = """
            SELECT
                c.id,
                c.nome,
                c.telefone,
                c.uf,
                c.cep,
                c.complemento,
                c.cpf,
                c.numero_processo,
                c.status_cliente,
                c.data_cadastro,
                s.descricao_status
            FROM Cliente c
            JOIN StatusCliente s ON c.status_cliente = s.codigo
            WHERE c.id = ?
        """;

        //Cria um statement usando a String sql
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            //Cria um objeto Cliente com os dados retornados pela query
            if (rs.next()) {
                Cliente cliente = new Cliente (
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

                //Não usa o construtor aqui, somente o setter, já que só é usado para exibir
                //o "descricao_status" para o usuário.
                cliente.setDescricaoStatus(rs.getString("descricao_status"));
                return cliente;
            }
        } catch (SQLException e) {
            System.err.println("\nErro ao buscar cliente por ID: " + e.getMessage() + "\n");
        }
        return null;
    }

    //Atualiza uma linha na tabela Cliente, conforme os atributos de um objeto Cliente
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

        //Cria um statement usando a String sql e os atributos de Cliente
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
            System.out.println("\nCliente atualizado com sucesso.");
        } catch (SQLException e) {
            System.err.println("\nErro ao atualizar cliente: " + e.getMessage() + "\n");
        }
    }

    //Deleta uma linha na tabela Cliente, conforme o id de um objeto Cliente
    public void deletarCliente(Cliente cliente){
        String sql = "DELETE FROM Cliente WHERE id = ?";

        //Cria um statement usando a String sql
        try (PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();
            System.out.println("\nCliente deletado com sucesso.");
        } catch (SQLException e) {
            System.err.println("\nErro ao deletar cliente: "+ e.getMessage() + "\n");
        }
    }
}
