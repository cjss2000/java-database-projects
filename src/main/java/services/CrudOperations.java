package services;

import java.sql.SQLException;
import java.util.List;

public interface CrudOperations<T> {

    void addObject(T objectToAdd) throws SQLException;
    // TODO: update delete methods to be void
    void deleteObjectById(int id) throws SQLException;
    T getObjectById(int id) throws SQLException;
    List<T> getAllObjects() throws SQLException;
}
