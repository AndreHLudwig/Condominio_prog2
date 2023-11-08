/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.dao;

import condominio.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author andre
 */
public class PessoaDAO {

    private final Connection connection;
    
    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Connection getConnection() {
        return this.connection;
    }

    public void insert(Pessoa pessoa, Pessoa x) {
        String sql = "INSERT Into pessoas(id_pessoa, nome, telefone, email) VALUES (?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pessoa.getIdPessoa());
            statement.setString(2, pessoa.getNome());
            statement.setString(3, pessoa.getTelefone());
            statement.setString(4, pessoa.getEmail());
            System.out.println("Pessoa adicionada com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }

    public void update(Pessoa pessoa) {
        String sql = "UPDATE pessoas "
                + "telefone = ?, "
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
        String sql = "DELETE FROM pessoas WHERE id_pessoa = ?";

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
