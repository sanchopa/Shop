package Model;

import java.util.ArrayList;
import java.util.List;

public class AbstractStorage<E> {
    private List<E> storage = new ArrayList<>();

    void addProduct (E product) {
        storage.add(product);
    }

    List<String> getStringListStorags(){
        List<String> stringListStorags = new ArrayList<>();
        for (E product: storage) {
            stringListStorags.add(product.toString());
        }
        return stringListStorags;
    }

    int getFreeNumber() {
        return storage.size()+1;
    }

    E getProduct(int index) {
        return storage.get(index);
    }

    void deleteProduct(int index) {
        storage.remove(index);
    }
}
