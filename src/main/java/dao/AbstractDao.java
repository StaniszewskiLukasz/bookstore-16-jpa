package dao;

public interface AbstractDao<T> {

    T find(long id);

    void insert(T t);

    void delete(T t);

    T update (T t);

}
