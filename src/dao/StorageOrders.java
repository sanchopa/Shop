package dao;

import model.Order;

import java.util.Map;

public class StorageOrders extends AbstractStorage<Order> {
    @Override
    Order parseProreties(Map<String, String> prop) {
        return new Order(Integer.valueOf(prop.get("orderNumber")));
    }
}
