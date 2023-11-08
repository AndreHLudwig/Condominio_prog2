/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominio.dao;

import condominio.Apartamento;
import condominio.Locatario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class LocatarioDAO implements GenericDAO<Locatario, Apartamento>{
    private final Connection connection;
    
    public LocatarioDAO (Connection connection){
        this.connection = connection;
    }
    
    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void insert(Locatario locatario, Apartamento apto) {
        String sql = "INSERT Into locatario(id_pessoa, cpf, id_apartamento) VALUES (?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, locatario.getIdPessoa());
            statement.setString(2, locatario.getCpf());
            statement.setInt(3, locatario.getApartamento().getIdApartamento());
            System.out.println("Locatário inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Locatário: " + e.getMessage());
        }
    }

    @Override
    public void update(Locatario locatario) {
        //Nothing TODO
    }

    @Override
    public void delete(int idPessoa) {
        String sql = "DELETE FROM locatario WHERE id_pessoa = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idPessoa);
            int rs = statement.executeUpdate();
            if (rs == 1) {
                System.out.println("Locatário excluído com sucesso!");
            } else {
                System.out.println("Locatário não encontrado!");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Locatário: " + e.getMessage());
        }
    }
    

    @Override
    public Locatario findById(int idLocatario){
        String sql = "SELECT * FROM pessoa_locatario WHERE id_pessoa = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idLocatario);
            ResultSet resultSet = statement.executeQuery();
            Locatario locatario = new Locatario();
            while (resultSet.next()) {
                locatario.setIdPessoa(resultSet.getInt("id_pessoa"));
//              apartamento.setLocatario(locatarioDAO.findbyApartamento(idApartamento));
                locatario.setNome(resultSet.getString("nome"));
                locatario.setTelefone(resultSet.getString("telefone"));
                locatario.setEmail(resultSet.getString("email"));
                locatario.setCpf(resultSet.getString("cpf"));
                locatario.getApartamento().setIdApartamento(resultSet.getInt("id_apartamento"));
            }
            resultSet.close();
            statement.close();
            return locatario;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar Locatario: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Locatario> findAll() {
         String sql = "SELECT * FROM pessoa_locatario";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Locatario> listaLocatarios = new ArrayList<>();
            while (resultSet.next()) {
                Locatario locatario = new Locatario();
                locatario.setIdPessoa(resultSet.getInt("id_pessoa"));
//              apartamento.setLocatario(locatarioDAO.findbyApartamento(idApartamento));
                locatario.setNome(resultSet.getString("nome"));
                locatario.setTelefone(resultSet.getString("telefone"));
                locatario.setEmail(resultSet.getString("email"));
                locatario.setCpf(resultSet.getString("cpf"));
                locatario.getApartamento().setIdApartamento(resultSet.getInt("id_apartamento"));
                listaLocatarios.add(locatario);
            }
            resultSet.close();
            statement.close();
            return listaLocatarios;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Locatarios: " + e.getMessage());
        }
    }
    
    public Locatario findByApartamento (Apartamento apartamento){
        String sql = "SELECT * FROM pessoa_locatario WHERE id_apartamento = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, apartamento.getIdApartamento());
            ResultSet resultSet = statement.executeQuery();
            Locatario locatario = new Locatario();
            while (resultSet.next()) {
                locatario.setIdPessoa(resultSet.getInt("id_pessoa"));
//              apartamento.setLocatario(locatarioDAO.findbyApartamento(idApartamento));
                locatario.setNome(resultSet.getString("nome"));
                locatario.setTelefone(resultSet.getString("telefone"));
                locatario.setEmail(resultSet.getString("email"));
                locatario.setCpf(resultSet.getString("cpf"));
                locatario.setApartamento(apartamento);

            }
            resultSet.close();
            statement.close();
            return locatario;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Locatário: " + e.getMessage());
        }
    }
    
}
