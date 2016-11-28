package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int orderNumber;
    private Client client;
    private List <Map<Product, Integer>> goods = new ArrayList();
    private double itemSum=0;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    void addProduct(Product product, int count)
    {
        Map<Product, Integer> productCount = new HashMap<>();
        productCount.put(product, count);
        goods.add(productCount);
        itemSum+=count*product.getPrice();
    }

    public double getItemSum() {
        return itemSum;
    }

    @Override
    public String toString() {
        return orderNumber +";" + client+ ";" + itemSum + "р.";
    }

    void deleteProduct (int index){
        Map<Product, Integer> productCount = goods.get(index);
        Product product = productCount.entrySet().iterator().next().getKey();
        int count = productCount.entrySet().iterator().next().getValue();
        itemSum-=count*(product.getPrice());
        goods.remove(index);
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
