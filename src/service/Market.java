package service;

import dao.StorageProducts;
import dao.StorageOrders;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

public class Market {
    private StorageProducts storageProducts;
    private StorageOrders storageOrders;
    private Order order = null;

    public Market(StorageProducts storageProducts, StorageOrders storageOrders) {
        this.storageProducts = storageProducts;
        this.storageOrders = storageOrders;
    }

    public Object[] getStringStorageGoods() {
        return storageProducts.getListString().toArray();
    }

    public Product addProductToOrder(int indexProduct, int count) {
        if(order==null) {
            order = new Order(storageOrders.getFreeNumber());
        }
        Product product =  storageProducts.get(indexProduct);
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
}
