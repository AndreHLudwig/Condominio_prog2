package condominio.dao; //Data Access Object

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;

import condominio.model.Administrador;
import condominio.model.Condominio;

public class CondominioDAO implements GenericDAO<Condominio, Administrador> {
    private final Connection connection;

    public CondominioDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }

    @Override
    public void insert(Condominio condominio, Administrador administrador) {
        String sql = "INSERT INTO condominio(nome, endereco, taxa_mensal_condominio, fator_multiplicador_metragem, valor_vaga_garagem) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, condominio.getNome());
            statement.setString(2, condominio.getEndereco());
            statement.setDouble(3, condominio.getTaxaMensalCondominio());
            statement.setDouble(4, condominio.getFatorMultiplicadorDeMetragem());
            statement.setDouble(5, condominio.getValorVagaGaragem());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idCondominio = generatedKeys.getInt(1);
                    condominio.setIdCondominio(idCondominio);
                    System.out.println("Condomínio inserido com sucesso! ID: " + idCondominio);
                } else {
                    throw new SQLException("A inserção falhou, nenhum ID gerado.");
                }
                generatedKeys.close();
            } else {
                throw new SQLException("A inserção falhou, nenhum registro afetado.");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Condomínio: " + e.getMessage());
        }
    }

    @Override
    public void update(Condominio condominio) {
        String sql = "UPDATE condominio "
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
            statement.setInt(6, condominio.getIdCondominio());
            statement.execute();
            statement.close();
            System.out.println("Condomínio alterado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar Condomínio: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM condominio WHERE id_condominio = ?";

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
    public Condominio findById(int id) {
        String sql = "SELECT * FROM condominio WHERE id_condominio = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Condominio condominio = new Condominio();
            while (resultSet.next()) {
                condominio.setIdCondominio(resultSet.getInt("id_condominio"));
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
            throw new RuntimeException("Erro ao pesquisar Condominio: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Condominio> findAll() {
        String sql = "SELECT * FROM condominio";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Condominio> listaCondominios = new ArrayList<>();
            while (resultSet.next()) {
                Condominio condominio = new Condominio();
                condominio.setIdCondominio(resultSet.getInt("id_condominio"));
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
            throw new RuntimeException("Erro ao listar condomínios: " + e.getMessage());
        }
    }
}
