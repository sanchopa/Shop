package Model;

import java.util.ArrayList;
import java.util.List;

public class AbstractStorage<E> {
    private List<E> storage = new ArrayList<>();

    public void addProduct(E product) {
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

    public E getProduct(int index) {
        return storage.get(index);
    }

    public void deleteProduct(int index) {
        storage.remove(index);
    }
}
