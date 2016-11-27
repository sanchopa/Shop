package Model;

import UI.Dialog;

public class Market {
    private StorageGoods storageGoods = new StorageGoods();
    private StorageOrders storageOrders = new StorageOrders();

    Order createNewOrder () {
        Client newClient = new Client(Dialog.getClientName(),
                                        Dialog.getClientSurname(), Dialog.getClientEmail(), Dialog.getClientPhone(),
                                            Dialog.getClientAddress());
        return new Order(storageOrders.getFreeNumber(),newClient);
    }

    public Object[] getStringStorageGoods() {
        return storageGoods.getStringListStorags().toArray();
    }

    public void addProductToStorage(Product product) {
        storageGoods.addProduct(product);
    }

    void sellOrder () {

    }

    void printStorageGoods() {

    }

    void printStorageOrders () {

    }
}
