package condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import condominio.model.Pessoa;

public class PessoaDAO {

    private final Connection connection;
    
    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    public void insert(Pessoa pessoa) {
        String sql = "INSERT Into pessoa(nome, telefone, email) VALUES (?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getTelefone());
            statement.setString(3, pessoa.getEmail());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idPessoa = generatedKeys.getInt(1);
                    pessoa.setIdPessoa(idPessoa);
                    System.out.println("Pessoa adicionada com sucesso! ID: " + idPessoa);
                } else {
                    throw new SQLException("A inserção falhou, nenhum ID gerado.");
                }
                generatedKeys.close();
            } else {
                throw new SQLException("A inserção falhou, nenhum registro afetado.");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }

    public void update(Pessoa pessoa) {
        String sql = "UPDATE pessoa "
                + "SET telefone = ?, "
                + "email = ? "
                + "WHERE id_pessoa = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pessoa.getTelefone());
            statement.setString(2, pessoa.getEmail());
            statement.setInt(3, pessoa.getIdPessoa());
            statement.execute();
            statement.close();
            System.out.println("Dados alterados com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar dados: " + e.getMessage());
        }
    }

    public void delete(int idPessoa) {
        String sql = "DELETE FROM pessoa WHERE id_pessoa = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idPessoa);
            int rs = statement.executeUpdate();
            if (rs == 1) {
                System.out.println("Pessoa excluída com sucesso!");
            } else {
                System.out.println("Pessoa não encontrada!");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Pessoa: " + e.getMessage());
        }
    }
    
}
