package dao;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStorage<E> {
    private List<E> list = new ArrayList<>();

    public void add(E item) {
        list.add(item);
    }

    public List<String> getListString(){
        List<String> stringList = new ArrayList<>();
        for (E item: list) {
            stringList.add(item.toString());
        }
        return stringList;
    }

    public int getFreeNumber() {
        return list.size()+1;
    }

    public E get(int index) {
        return list.get(index);
    }

    public void delete(int index) {
        list.remove(index);
    }
}
