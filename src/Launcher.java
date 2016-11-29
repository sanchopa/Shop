import service.Market;
import model.Product;
import dao.StorageGoods;
import dao.StorageOrders;
import UI.Dialog;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {

        StorageGoods storageGoods = new StorageGoods();
        StorageOrders storageOrders = new StorageOrders();

        Market market = new Market(storageGoods, storageOrders);

        if(args[1].equals("o")) {
            market.addProductToStorage(new Product("Философия Java", "Эккель Брюс",
                    "Питер", "2015", "1224"));
            market.addProductToStorage(new Product("Изучаем Java", "Сьерра Кэтти, Бейтс Берт",
                    "Эксмо", "2012", "659"));
            market.addProductToStorage(new Product("Java 8. Полное руководство", "Шилдт Герберт",
                    "Вильямс", "2015", "3097"));
        }
        else{
            market.getStorageGoodsFromFile(args[1]);
        }

        JFrame myWindow = new Dialog(market);
        myWindow.setVisible(true);
    }
}
