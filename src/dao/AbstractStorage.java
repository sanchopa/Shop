package dao;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStorage<E> {
    private List<E> storage = new ArrayList<>();

    public void add(E product) {
        storage.add(product);
    }

    public List<String> getStringListStorags(){
        List<String> stringListStorags = new ArrayList<>();
        for (E product: storage) {
            stringListStorags.add(product.toString());
        }
        return stringListStorags;
    }

    public int getFreeNumber() {
        return storage.size()+1;
    }

    public E get(int index) {
        return storage.get(index);
    }

    public void delete(int index) {
        storage.remove(index);
    }
}
