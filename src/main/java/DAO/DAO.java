package DAO;

import java.util.List;

public interface DAO<T> {
    void add(T type);
    void delete(T type);
    void update(T type);
    T getObjectById(Long id);
    List<T> getAll();
}
