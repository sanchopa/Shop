package Model;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private Client client;
    private List <Pair<Product, Integer>> goods = new ArrayList();

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    void addProduct(Product product, int count)
    {
        goods.add(new Pair<>(product, count));
    }

    public double getOrderPrice() {
        double orderPrice = 0;
        for (Pair<Product, Integer> productCount:goods) {
            orderPrice+=productCount.getKey().getPrice()*productCount.getValue();
        }
        return orderPrice;
    }

    @Override
    public String toString() {
        return "#" + orderNumber +" " + client+ " total: " + getOrderPrice() + " RUB";
    }

    void deleteProduct (int index){
        Pair<Product, Integer> productCount = goods.get(index);
        Product product = productCount.getKey();
        int count = productCount.getValue();
        goods.remove(index);
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
