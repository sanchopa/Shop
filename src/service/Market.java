package service;

import dao.StorageGoods;
import dao.StorageOrders;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

public class Market {
    private StorageGoods storageGoods;
    private StorageOrders storageOrders;
    private Order order = null;

    public Market(StorageGoods storageGoods, StorageOrders storageOrders) {
        this.storageGoods = storageGoods;
        this.storageOrders = storageOrders;
    }

    public Object[] getStringStorageGoods() {
        return storageGoods.getListString().toArray();
    }

    public Product addProductToOrder(int indexProduct, int count) {
        if(order==null) {
            order = new Order(storageOrders.getFreeNumber());
        }
        Product product =  storageGoods.get(indexProduct);
        order.addProduct(product, count);
        return  product;
    }

    public String getStringOrderPrice() {
        return String.valueOf(order.getOrderPrice());
    }

    public String deleteProductFromOrder(int index) {
        order.deleteProduct(index);
        return getStringOrderPrice();
    }

    public Order buyOrder(String name, String surname, String email, String phone, String address) {
        Client client = new Client(name,surname,email,phone, address);
        order.setClient(client);
        storageOrders.add(order);
        return order;
    }

    public void newOrder(){
        order=null;
    }

    public void deleteOrder(int index) {
        storageOrders.delete(index);
    }

    public void getStorageGoodsFromFile (String fileName) {
        if (fileName == null) {
            return;
        }
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new BufferedReader(new FileReader(fileName)));
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                Map<String, String> propertiesProduct = new HashMap<>();
                String[] strClient =line.split(";");
                for (String properties:strClient) {
                    propertiesProduct.put(properties.split("=")[0], properties.split("=")[1]);
                }
                storageGoods.add(new Product(propertiesProduct.get("Title"), propertiesProduct.get("Author"),
                                                    propertiesProduct.get("Publishing"), propertiesProduct.get("Year"),
                                                        propertiesProduct.get("Price")));
            }
            lineNumberReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
