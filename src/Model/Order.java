package Model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderNumber;
    private Client client;
    private Map<Product, Integer> goods= new HashMap<>();
    private double itemSum=0;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    void addProduct(Product product, int count)
    {
        goods.put(product, count);
        itemSum+=count*product.getPrice();
    }

    public double getItemSum() {
        return itemSum;
    }

    @Override
    public String toString() {
        return orderNumber +";" + client+ ";" + itemSum + "р.";
    }
}
