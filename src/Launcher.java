import Model.Market;
import Model.Product;
import UI.Dialog;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {

        Market market = new Market();
        market.addProductToStorage(new Product("Философия Java", "Эккель Брюс",
                                                "Питер","2015", (double) 1224));
        market.addProductToStorage(new Product("Изучаем Java", "Сьерра Кэтти, Бейтс Берт",
                                                "Эксмо","2012", (double) 659));
        market.addProductToStorage(new Product("Java 8. Полное руководство", "Шилдт Герберт",
                                                "Вильямс","2015", (double) 3097));

        JFrame myWindow = new Dialog(market);
        myWindow.setVisible(true);
    }
}
