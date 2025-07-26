package services;

import java.sql.SQLException;

public interface CrudOperations<T> {

    void addObject(T objectToAdd) throws SQLException;
    T deleteObjectById(int id) throws SQLException;
    T getObjectById(int id) throws SQLException;

}
