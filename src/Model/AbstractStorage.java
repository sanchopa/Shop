package Model;

import java.util.ArrayList;
import java.util.List;

public class AbstractStorage<E> {
    List<E> storags = new ArrayList<E>();

    void addProduct (E product) {
        storags.add(product);
    }

    List<String> getStringListStorags(){
        List<String> stringListStorags = new ArrayList<>();
        for (E product: storags) {
            stringListStorags.add(product.toString());
        }
        return stringListStorags;
    }

    int getFreeNumber() {
        return storags.size()+1;
    }

    E getProduct(int index) {
        return storags.get(index);
    }
}
