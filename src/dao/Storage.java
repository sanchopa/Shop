package dao;

import java.util.List;

public interface Storage<E> {
    void add(E item);
    List<String> getListString();
    E get(int index);
    void delete(int index);
}
