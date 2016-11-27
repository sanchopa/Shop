package Model;

import UI.Dialog;

public class Market {
    private StorageGoods storageGoods = new StorageGoods();
    private StorageOrders storageOrders = new StorageOrders();
    private Order order = null;

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

    public String getTottalSum () {
        return String.valueOf(order.getItemSum());
    }

}
