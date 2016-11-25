import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class Dialog extends JFrame {
    public Dialog() throws HeadlessException {
        super("Book shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box boxClientField = Box.createHorizontalBox();
        boxClientField.add(new JLabel("Name:"));
        boxClientField.add(new JTextField(10));
        boxClientField.add(new JLabel("Surname:"));
        boxClientField.add(new JTextField(10));
        boxClientField.add(new JLabel("Phone num.:"));
        boxClientField.add(new JTextField(10));
        boxClientField.add(new JLabel("E-mail:"));
        boxClientField.add(new JTextField(10));
        boxClientField.add(new JLabel("Address:"));
        boxClientField.add(new JTextField(10));

        Box boxClient = Box.createVerticalBox();
        boxClient.add(boxClientField);

        Box boxProductTable = Box.createVerticalBox();
        String[] columnNames = {"Title", "Author", "Genre", "Publishing", "Year", "Price"};
        Object[][] data = {{"Философия Java", "Эккель Брюс", "Программирование", "Питер", "2015","1224"},
                {"Изучаем Java", "Сьерра Кэтти, Бейтс Берт", "Программирование", "Эксмо", "2012","659"},
                {"Java 8. Полное руководство", "Шилдт Герберт", "Программирование", "Вильямс", "2015","3097"}};
        JTable tableProduct = new JTable(data, columnNames);
        boxProductTable.add(tableProduct.getTableHeader());
        boxProductTable.add(tableProduct);
        boxProductTable.add(new JButton("Add."));

        Box boxProduct = Box.createVerticalBox();
        boxProduct.add(boxProductTable);

        Box boxNewOrder = Box.createVerticalBox();
        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        boxNewOrder.add(listScrollPane);
        boxNewOrder.add(new JButton("Add"));

        Box boxOrderList = Box.createVerticalBox();
          JList listOrder = new JList();
          listOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          listOrder.setSelectedIndex(0);
          listOrder.setVisibleRowCount(5);
          JScrollPane listOrderScrollPane = new JScrollPane(listOrder);
          boxOrderList.add(listOrderScrollPane);


        Box boxOrder = Box.createVerticalBox();
        boxOrder.add(boxNewOrder);
        boxOrder.add(boxOrderList);

        Box boxGeneral = Box.createVerticalBox();
        boxGeneral.add(boxClient);
        boxGeneral.add(boxProduct);
        boxGeneral.add(boxOrder);

        setContentPane(boxGeneral);
        pack();
    }
}
