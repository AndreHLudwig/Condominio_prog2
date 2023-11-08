package condominio.dao;

import condominio.Apartamento;
import condominio.Bloco;
import condominio.Condominio;
import condominio.Locatario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class ApartamentoDAO implements GenericDAO<Apartamento, Bloco>{
    private final Connection connection;

    public ApartamentoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void insert(Apartamento apartamento, Bloco bloco) {
        String sql = "INSERT Into apartamentos(id_apartamento, numero, metragem, vagas_de_garagem, valor_aluguel) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bloco.getIdBloco());
            statement.setString(2, apartamento.getNumero());
            statement.setDouble(3, apartamento.getMetragem());
            statement.setInt(4, apartamento.getVagasDeGaragem());
            statement.setDouble(5, apartamento.getValorAluguel());
            System.out.println("Apartamento inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Apartamento: " + e.getMessage());
        }
    }

    @Override
    public void update(Apartamento apartamento) {
        String sql = "UPDATE apartamentos "
                + "SET id_pessoa = ?, "
                + "vagas_de_garagem = ?, "
                + "valor_aluguel = ? "
                + "WHERE id_apartamento = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, apartamento.getLocatario().getIdPessoa());
            statement.setInt(2, apartamento.getVagasDeGaragem());
            statement.setDouble(3, apartamento.getValorAluguel());
            statement.setInt(4, apartamento.getIdApartamento());
            statement.execute();
            statement.close();
            System.out.println("Apartamento alterado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar Apartamento: " + e.getMessage());
        }
    }

    @Override
    public void delete(int idApartamento) {
        String sql = "DELETE FROM apartamentos WHERE id_apartamento = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idApartamento);
            int rs = statement.executeUpdate();
            if (rs == 1) {
                System.out.println("Apartamento excluído com sucesso!");
            } else {
                System.out.println("Apartamento não encontrado!");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Apartamento: " + e.getMessage());
        }
    }

    @Override
    public Apartamento findById(int idApartamento) {
        String sql = "SELECT * FROM apartamentos WHERE id_apartamento = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idApartamento);
            ResultSet resultSet = statement.executeQuery();
            Apartamento apartamento = new Apartamento();
            while (resultSet.next()) {
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
//                apartamento.setLocatario(locatarioDAO.findbyAbartamento(idApartamento));
                apartamento.setNumero(resultSet.getString("numero"));
                apartamento.setMetragem(resultSet.getDouble("metragem"));
                apartamento.setVagasDeGaragem(resultSet.getInt("vagas_de_garagem"));
                apartamento.setValorAluguel(resultSet.getDouble("valor_aluguel"));
            }
            resultSet.close();
            statement.close();
            return apartamento;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar Apartamento: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Apartamento> findAll() {
        String sql = "SELECT * FROM apartamentos";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento();
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
//                apartamento.setLocatario(locatarioDAO.findbyApartamento(idApartamento));
                apartamento.setNumero(resultSet.getString("numero"));
                apartamento.setMetragem(resultSet.getDouble("metragem"));
                apartamento.setVagasDeGaragem(resultSet.getInt("vagas_de_garagem"));
                apartamento.setValorAluguel(resultSet.getDouble("valor_aluguel"));

                listaApartamentos.add(apartamento);
            }
            resultSet.close();
            statement.close();
            return listaApartamentos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Apartamentos: " + e.getMessage());
        }
    }

    public ArrayList<Apartamento> findByLocatario(Locatario locatario) {
        String sql = "SELECT * FROM apartamentos WHERE id_pessoa = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, locatario.getIdPessoa());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento();
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
//                apartamento.setLocatario(locatarioDAO.findbyId(locatario.getIdPessoa()));
                apartamento.setNumero(resultSet.getString("numero"));
                apartamento.setMetragem(resultSet.getDouble("metragem"));
                apartamento.setVagasDeGaragem(resultSet.getInt("vagas_de_garagem"));
                apartamento.setValorAluguel(resultSet.getDouble("valor_aluguel"));

                listaApartamentos.add(apartamento);
            }
            resultSet.close();
            statement.close();
            return listaApartamentos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Apartamentos: " + e.getMessage());
        }

    }

}