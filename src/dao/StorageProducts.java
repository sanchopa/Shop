package dao;

import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

public class StorageProducts extends AbstractStorage<Product> {
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
                add(new Product(prop.get("Title"), prop.get("Author"), prop.get("Publishing"), prop.get("Year"),
                        prop.get("Price")));
            }
            lineNumberReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
