package services;

public interface CrudOperations<T> {

    void addObject(T objectToAdd);
    T deleteObjectById(int id);
    T getObjectById(int id);

}
