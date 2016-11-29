package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractStorage<E> {
    private List<E> list = new ArrayList<>();

    abstract E parseProreties(Map<String, String> prop);

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

    public void getStorageFromFile(String fileName) {
        if (fileName == null) {
            return;
        }
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader(fileName)));
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                Map<String, String> prop = new HashMap<>();
                String[] strClient =line.split(";");
                for (String properties:strClient) {
                    prop.put(properties.split("=")[0], properties.split("=")[1]);
                }
                add(parseProreties(prop));
            }
            lineNumberReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
