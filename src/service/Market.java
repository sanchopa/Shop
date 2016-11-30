package service;

import dao.StorageProducts;
import dao.StorageOrders;
import model.*;

public class Market {
    private StorageProducts storageProducts;
    private StorageOrders storageOrders;
    private Order order = null;

    public Market(StorageProducts storageProducts, StorageOrders storageOrders) {
        this.storageProducts = storageProducts;
        this.storageOrders = storageOrders;
    }

    public Object[] getStringStorageProducts() {
        return storageProducts.getListString().toArray();
    }

    public Product addProductToOrder(int indexProduct, int count) {
        if(order==null) {
            order = new Order();
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
        if(order==null) {
            return null;
        }
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
