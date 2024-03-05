package condominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import condominio.model.Administrador;
import condominio.model.Condominio;

public class AdministradorDAO implements GenericDAO<Administrador, Condominio>{
    private final Connection connection;

    public AdministradorDAO (Connection connection){
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void insert(Administrador administrador, Condominio condominio) {
        String sql = "INSERT Into administrador(id_pessoa, cnpj, id_condominio) VALUES (?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, administrador.getIdPessoa());
            statement.setString(2, administrador.getCnpj());
            statement.setInt(3, (condominio == null) ? administrador.getCondominio().getIdCondominio() : condominio.getIdCondominio());
            statement.executeUpdate();
            statement.close();
            System.out.println("Administrador inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Administrador: " + e.getMessage());
        }
    }

    @Override
    public void update(Administrador administrador) {
        //Nothing TODO
    }

    @Override
    public void delete(int idPessoa) {
        String sql = "DELETE FROM administrador WHERE id_pessoa = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idPessoa);
            int rs = statement.executeUpdate();
            if (rs == 1) {
                System.out.println("Administrador excluído com sucesso!");
            } else {
                System.out.println("Administrador não encontrado!");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Administrador: " + e.getMessage());
        }
    }


    @Override
    public Administrador findById(int idAdministrador){
        String sql = "SELECT * FROM pessoa_administrador WHERE id_pessoa = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idAdministrador);
            ResultSet resultSet = statement.executeQuery();
            Administrador administrador = new Administrador();
            while (resultSet.next()) {
                administrador.setIdPessoa(resultSet.getInt("id_pessoa"));
                administrador.getCondominio().setIdCondominio(resultSet.getInt("id_condominio"));
                administrador.setNome(resultSet.getString("nome"));
                administrador.setTelefone(resultSet.getString("telefone"));
                administrador.setEmail(resultSet.getString("email"));
                administrador.setCnpj(resultSet.getString("cnpj"));
            }
            resultSet.close();
            statement.close();
            return administrador;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar Administrador: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Administrador> findAll() {
        String sql = "SELECT * FROM pessoa_administrador";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Administrador> listaAdministradores = new ArrayList<>();
            while (resultSet.next()) {
                Administrador administrador = new Administrador();
                administrador.setIdPessoa(resultSet.getInt("id_pessoa"));
                administrador.setNome(resultSet.getString("nome"));
                administrador.setTelefone(resultSet.getString("telefone"));
                administrador.setEmail(resultSet.getString("email"));
                administrador.setCnpj(resultSet.getString("cnpj"));
                administrador.getCondominio().setIdCondominio(resultSet.getInt("id_condominio"));
                listaAdministradores.add(administrador);
            }
            resultSet.close();
            statement.close();
            return listaAdministradores;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Administradores: " + e.getMessage());
        }
    }

    public Administrador findByCondominio (Condominio condominio){
        String sql = "SELECT * FROM pessoa_administrador WHERE id_condominio = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, condominio.getIdCondominio());
            ResultSet resultSet = statement.executeQuery();
            Administrador administrador = new Administrador();
            while (resultSet.next()) {
                administrador.setIdPessoa(resultSet.getInt("id_pessoa"));
                administrador.setNome(resultSet.getString("nome"));
                administrador.setTelefone(resultSet.getString("telefone"));
                administrador.setEmail(resultSet.getString("email"));
                administrador.setCnpj(resultSet.getString("cnpj"));
                condominio.setIdCondominio((resultSet.getInt("id_condominio")));
                administrador.setCondominio(condominio);
            }
            resultSet.close();
            statement.close();
            return administrador;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Administradores: " + e.getMessage());
        }
    }
}
