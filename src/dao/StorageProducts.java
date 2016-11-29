package dao;

import model.Product;

import java.util.Map;

public class StorageProducts extends AbstractStorage<Product> {
    @Override
    Product parseProreties(Map<String, String> prop) {
        return new Product(prop.get("Title"), prop.get("Author"), prop.get("Publishing"), prop.get("Year"),
                                prop.get("Price"));
    }
}
