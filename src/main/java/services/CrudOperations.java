package services;

import java.sql.SQLException;

public interface CrudOperations<T> {

    void addObject(T objectToAdd) throws SQLException;
    // TODO: update delete methods to be void
    T deleteObjectById(int id) throws SQLException;
    T getObjectById(int id) throws SQLException;

}
