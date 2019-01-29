package ru.ncedu.simpleweb.repositories;

import java.util.List;

public interface Repository<T,Id> {
    List<T> get();
    T get(Id id);
    T add(T object);
    T update(T object);
    boolean remove(T object);
    boolean removeById(Id id);
}
