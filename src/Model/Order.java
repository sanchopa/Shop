package Model;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private Client client;
    private List <Pair<Product, Integer>> goods = new ArrayList();
    private double itemSum=0;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    void addProduct(Product product, int count)
    {
        goods.add(new Pair<>(product, count));
        itemSum+=count*product.getPrice();
    }

    public double getItemSum() {
        return itemSum;
    }

    @Override
    public String toString() {
        return "#" + orderNumber +" " + client+ " total: " + itemSum + " RUB";
    }

    void deleteProduct (int index){
        Pair<Product, Integer> productCount = goods.get(index);
        Product product = productCount.getKey();
        int count = productCount.getValue();
        itemSum-=count*(product.getPrice());
        goods.remove(index);
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
