package condominio.dao;

import condominio.model.Bloco;
import condominio.model.Condominio;

import java.sql.*;
import java.util.ArrayList;

public class BlocoDAO implements GenericDAO<Bloco, Condominio>{
    private final Connection connection;

    public BlocoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
    @Override
    public void insert(Bloco bloco, Condominio condominio) {
        String sql = "INSERT Into bloco(id_condominio, nome, andares, vagas_de_garagem) VALUES (?,?,?,?);";
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, condominio.getIdCondominio());
            statement.setString(2, bloco.getNome());
            statement.setInt(3, bloco.getAndares());
            statement.setInt(4, bloco.getVagasDeGaragem());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idBloco = generatedKeys.getInt(1);
                    bloco.setIdBloco(idBloco);
                    System.out.println("Bloco inserido com sucesso! ID:" + idBloco);
                } else {
                    throw new SQLException("A inserção falhou, nenhum ID gerado.");
                }
                generatedKeys.close();
            } else {
                throw new SQLException("A inserção falhou, nenhum registro afetado.");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir Bloco: " + e.getMessage());
        }
    }

    @Override
    public void update(Bloco bloco) {
        String sql = "UPDATE bloco "
                + "SET nome = ?, "
                + "vagas_de_garagem = ? " //atenção as vírgulas
                + "WHERE id_bloco = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bloco.getNome());
            statement.setInt(2, bloco.getVagasDeGaragem());
            statement.setInt(3, bloco.getIdBloco());
            statement.execute();
            statement.close();
            System.out.println("Bloco alterado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar Bloco: " + e.getMessage());
        }
    }

    @Override
    public void delete(int idBloco) {
        String sql = "DELETE FROM bloco WHERE id_bloco = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idBloco);
            int rs = statement.executeUpdate();
            if (rs == 1) {
                System.out.println("Bloco excluído com sucesso!");
            } else {
                System.out.println("Bloco não encontrado!");
            }
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Bloco: " + e.getMessage());
        }
    }

    @Override
    public Bloco findById(int idBloco) {
        String sql = "SELECT * FROM bloco WHERE id_bloco = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idBloco);
            ResultSet resultSet = statement.executeQuery();
            Bloco bloco = new Bloco();
            while (resultSet.next()) { 
                bloco.setIdBloco(resultSet.getInt("id_bloco"));
//                bloco.setApartamentos(apartamentoDAO.findbyBloco(id_bloco));
                bloco.setNome(resultSet.getString("nome"));
                bloco.setAndares(resultSet.getInt("andares"));
                bloco.setVagasDeGaragem(resultSet.getInt("vagas_de_garagem"));
            }
            resultSet.close();
            statement.close();
            return bloco;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar Bloco: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Bloco> findAll() {
        String sql = "SELECT * FROM bloco";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Bloco> listaBlocos = new ArrayList<>();
            while (resultSet.next()) {
                Bloco bloco = new Bloco();
                bloco.setIdBloco(resultSet.getInt("id_bloco"));
//                bloco.setApartamentos(apartamentoDAO.findbyBloco(bloco));
                bloco.setNome(resultSet.getString("nome"));
                bloco.setAndares(resultSet.getInt("andares"));
                bloco.setVagasDeGaragem(resultSet.getInt("vagas_de_garagem"));

                listaBlocos.add(bloco);
            }
            resultSet.close();
            statement.close();
            return listaBlocos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Blocos: " + e.getMessage());
        }
    }

    public ArrayList<Bloco> findByCondominio(Condominio condominio) {
        String sql = "SELECT * FROM bloco WHERE id_condominio = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, condominio.getIdCondominio());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Bloco> listaBlocos = new ArrayList<>();
            while (resultSet.next()) {
                Bloco bloco = new Bloco();
                bloco.setIdBloco(resultSet.getInt("id_bloco"));
//                bloco.setApartamentos(apartamentoDAO.findbyBloco(bloco));
                bloco.setNome(resultSet.getString("nome"));
                bloco.setAndares(resultSet.getInt("andares"));
                bloco.setVagasDeGaragem(resultSet.getInt("vagas_de_garagem"));

                listaBlocos.add(bloco);
            }
            resultSet.close();
            statement.close();
            return listaBlocos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar Blocos: " + e.getMessage());
        }

    }

}