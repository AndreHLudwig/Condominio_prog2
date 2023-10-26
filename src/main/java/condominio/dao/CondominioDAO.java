package condominio.dao;

import condominio.Condominio;

import java.sql.*;
import java.util.ArrayList;

public class CondominioDAO implements GenericDAO<Condominio> {

    @Override
    public void insert(Connection connection, Condominio condominio) {
        String sql = "INSERT INTO condominios(nome, endereco, taxa_mensal_condominio, fator_multiplicador_metragem, valor_vaga_garagem) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, condominio.getNome());
            statement.setString(2, condominio.getEndereco());
            statement.setDouble(3, condominio.getTaxaMensalCondominio());
            statement.setDouble(4, condominio.getFatorMultiplicadorDeMetragem());
            statement.setDouble(5, condominio.getValorVagaGaragem());
            statement.execute();
            statement.close();
            System.out.println("Condomínio inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Condomínio: " + e.getMessage());
        }
    }

    @Override
    public void update(Connection connection, Condominio condominio) {
        String sql = "UPDATE condominios "
                + "SET nome = ?, "
                + "endereco = ?, "
                + "taxa_mensal_condominio = ?, "
                + "fator_multiplicador_metragem = ?, "
                + "valor_vaga_garagem = ? "
                + "WHERE id_condominio = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, condominio.getNome());
            statement.setString(2, condominio.getEndereco());
            statement.setDouble(3, condominio.getTaxaMensalCondominio());
            statement.setDouble(4, condominio.getFatorMultiplicadorDeMetragem());
            statement.setDouble(5, condominio.getValorVagaGaragem());
            statement.setInt(6, condominio.getId());
            statement.execute();
            statement.close();
            System.out.println("Condomínio alterado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar Condomínio: " + e.getMessage());
        }
    }

    @Override
    public void delete(Connection connection, int id) {
        String sql = "DELETE FROM condominios WHERE id_condominio = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rs = statement.executeUpdate();
            if (rs == 1) {
                System.out.println("Condomínio excluído com sucesso!");
            } else {
                System.out.println("Condomínio não encontrado!");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Condomínio: " + e.getMessage());
        }
    }

    @Override
    public Condominio findById(Connection connection, int id) {
        String sql = "SELECT * FROM condominios WHERE id_condominio = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Condominio condominio = new Condominio();
            while (resultSet.next()) {
                condominio.setId(resultSet.getInt("id_condominio"));
                condominio.setNome(resultSet.getString("nome"));
                condominio.setEndereco(resultSet.getString("endereco"));
                condominio.setTaxaMensalCondominio(resultSet.getDouble("taxa_mensal_condominio"));
                condominio.setFatorMultiplicadorDeMetragem(resultSet.getDouble("fator_multiplicador_metragem"));
                condominio.setValorVagaGaragem(resultSet.getDouble("valor_vaga_garagem"));
            }
            resultSet.close();
            statement.close();
            return condominio;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar aluno: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Condominio> findAll(Connection connection) {
        String sql = "SELECT * FROM condominios";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Condominio> listaCondominios = new ArrayList<>();
            while (resultSet.next()) {
                Condominio condominio = new Condominio();
                condominio.setId(resultSet.getInt("id_condominio"));
                condominio.setNome(resultSet.getString("nome"));
                condominio.setEndereco(resultSet.getString("endereco"));
                condominio.setTaxaMensalCondominio(resultSet.getDouble("taxa_mensal_condominio"));
                condominio.setFatorMultiplicadorDeMetragem(resultSet.getDouble("fator_multiplicador_metragem"));
                condominio.setValorVagaGaragem(resultSet.getDouble("valor_vaga_garagem"));
                listaCondominios.add(condominio);
            }
            resultSet.close();
            statement.close();
            return listaCondominios;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos: " + e.getMessage());
        }
    }
}
