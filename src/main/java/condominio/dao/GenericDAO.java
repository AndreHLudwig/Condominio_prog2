package condominio.dao;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

public interface GenericDAO<T> {

    void insert(Connection connection, T entity);
    void update(Connection connection, T entity);
    void delete(Connection connection, int id);
    T findById(Connection connection, int id);
    ArrayList<T> findAll(Connection connection);

}
