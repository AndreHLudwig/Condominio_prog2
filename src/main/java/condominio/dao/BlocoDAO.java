package condominio.dao;

import condominio.Bloco;
import condominio.Condominio;

import java.sql.Connection;
import java.util.ArrayList;

public class BlocoDAO implements GenericDAO<Bloco>{
    private final Connection connection;

    public BlocoDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
    @Override
    public void insert(Bloco bloco) {
        //TODO
    }

    @Override
    public void update(Bloco bloco) {
        //TODO
    }

    @Override
    public void delete(int idBloco) {
        //TODO
    }

    @Override
    public Bloco findById(int idBloco) {
        //TODO
        return null;
    }

    @Override
    public ArrayList<Bloco> findAll() {
        //TODO
        return null;
    }

    public ArrayList<Bloco> findByCondominio(Condominio condominio) {
        //TODO retornar todos os blocos de um condomínio
        /*EX: SELECT * FROM blocos WHERE id_condominio = 1;
              usando o condominio.getIdCondominio*/
        return null;

    }

    public ArrayList<Bloco> findByListaDeBlocosDoCondominio(ArrayList<Bloco> blocos) {
        //TODO ?

        return null;
    }
}
