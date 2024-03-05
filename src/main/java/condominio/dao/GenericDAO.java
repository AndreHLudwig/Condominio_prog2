package condominio.dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface GenericDAO<T, A> {

    Connection getConnection(); // Indica necessidade de conexão
    void insert(T entity, A otherEntity);
    void update(T entity);
    void delete(int id);
    T findById(int id);
    ArrayList<T> findAll();

}
