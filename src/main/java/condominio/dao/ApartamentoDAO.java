package condominio.dao;

import condominio.model.Apartamento;
import condominio.model.Bloco;
import condominio.model.Locatario;

import java.sql.*;
import java.util.ArrayList;

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
        String sql = "INSERT Into apartamento(id_bloco, numero, metragem, vagas_de_garagem, valor_aluguel) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, bloco.getIdBloco());
            statement.setString(2, apartamento.getNumero());
            statement.setDouble(3, apartamento.getMetragem());
            statement.setInt(4, apartamento.getVagasDeGaragem());
            statement.setDouble(5, apartamento.getValorAluguel());

            int affectedRows = statement.executeUpdate();

            if ((affectedRows > 0)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()) {
                    int idApartamento = generatedKeys.getInt(1);
                    apartamento.setIdApartamento(idApartamento);
                    System.out.println("Apartamento inserido com sucesso! ID: " + idApartamento);
                } else {
                    throw new SQLException("A inserção falhou, nenhum ID gerado.");
                }
                generatedKeys.close();
            } else  {
                throw new SQLException("A inserção falhou, nenhum registro afetado.");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Apartamento: " + e.getMessage());
        }
    }

    @Override
    public void update(Apartamento apartamento) {
        String sql = "UPDATE apartamento "
                + "SET id_locatario = ?, "
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
        String sql = "DELETE FROM apartamento WHERE id_apartamento = ?";

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
        String sql = "SELECT * FROM apartamento WHERE id_apartamento = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idApartamento);
            ResultSet resultSet = statement.executeQuery();
            Apartamento apartamento = new Apartamento();
            while (resultSet.next()) {
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
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
        String sql = "SELECT * FROM apartamento";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento();
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
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
        String sql = "SELECT * FROM apartamento WHERE id_locatario = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, locatario.getIdPessoa());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento();
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
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

    public ArrayList<Apartamento> findByBloco(Bloco bloco) {
        String sql = "SELECT * FROM apartamento WHERE id_bloco = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bloco.getIdBloco());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Apartamento> listaApartamentos = new ArrayList<>();
            while (resultSet.next()) {
                Apartamento apartamento = new Apartamento();
                apartamento.setIdApartamento(resultSet.getInt("id_apartamento"));
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