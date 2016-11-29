package model;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Client client;
    private List <Pair<Product, Integer>> products = new ArrayList();


    public void addProduct(Product product, int count)
    {
        products.add(new Pair<>(product, count));
    }

    public double getOrderPrice() {
        double orderPrice = 0;
        for (Pair<Product, Integer> productCount: products) {
            orderPrice+=productCount.getKey().getPrice()*productCount.getValue();
        }
        return orderPrice;
    }

    @Override
    public String toString() {
        return client+ " total: " + getOrderPrice() + " RUB";
    }

    public void deleteProduct(int index){
        products.remove(index);
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
