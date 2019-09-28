package data;

import java.util.Collection;

public interface Repository<ID, E> {
    E findById(ID id);
    Collection<E> findAll();
    void save(E obj);
    void delete(String obj);
}
