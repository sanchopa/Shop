package Service;

import Model.*;

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
        return storageGoods.getStringListStorags().toArray();
    }

    public void addProductToStorage(Product product) {
        storageGoods.addProduct(product);
    }

    public Product addProductToOrder(int indexProduct, int count) {
        if(order==null) {
            order = new Order(storageOrders.getFreeNumber());
        }
        Product product =  storageGoods.getProduct(indexProduct);
        order.addProduct(product, count);
        return  product;
    }

    public String getTotalSum() {
        return String.valueOf(order.getOrderPrice());
    }

    public String deleteProductFromOrder(int index) {
        order.deleteProduct(index);
        return getTotalSum();
    }

    public Order buyOrder(String name, String surname, String email, String phone, String address) {
        Client client = new Client(name,surname,email,phone, address);
        order.setClient(client);
        storageOrders.addProduct(order);
        return order;
    }

    public void newOrder(){
        order=null;
    }

    public void deleteOrder(int index) {
        storageOrders.deleteProduct(index);
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
                addProductToStorage(new Product(propertiesProduct.get("Title"), propertiesProduct.get("Author"),
                                                    propertiesProduct.get("Publishing"), propertiesProduct.get("Year"),
                                                        propertiesProduct.get("Price")));
            }
            lineNumberReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
