import service.Market;
import model.Product;
import dao.StorageProducts;
import dao.StorageOrders;
import UI.Dialog;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        StorageProducts storageProducts = new StorageProducts();
        StorageOrders storageOrders = new StorageOrders();

        if(args[1].equals("o")) {
            storageProducts.add(new Product("Философия Java", "Эккель Брюс",
                    "Питер", "2015", "1224"));
            storageProducts.add(new Product("Изучаем Java", "Сьерра Кэтти, Бейтс Берт",
                    "Эксмо", "2012", "659"));
            storageProducts.add(new Product("Java 8. Полное руководство", "Шилдт Герберт",
                    "Вильямс", "2015", "3097"));
        }
        else{
            storageProducts.getStorageFromFile(args[1]);
        }

        Market market = new Market(storageProducts, storageOrders);

        JFrame myWindow = new Dialog(market);
        myWindow.setVisible(true);
    }
}
