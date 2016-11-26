import javax.swing.*;
import javax.swing.border.TitledBorder;
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
        boxClient.setBorder(new TitledBorder("Client"));
        boxClient.add(boxClientField);

        Box boxProductList = Box.createVerticalBox();
        JList listProduct = new JList();
        listProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listProduct.setSelectedIndex(0);
        listProduct.setVisibleRowCount(5);
        JScrollPane listProductScrollPane = new JScrollPane(listProduct);
        boxProductList.add(listProductScrollPane);

        Box boxAddProductList = Box.createHorizontalBox();
        boxAddProductList.add(new JLabel("Count:"));
        JTextField fieldCountProduct = new JTextField(3);
        fieldCountProduct.setMaximumSize(fieldCountProduct.getPreferredSize());
        boxAddProductList.add(fieldCountProduct);
        boxAddProductList.add(new JButton("Add to order"));

        Box boxProduct = Box.createVerticalBox();
        boxProduct.setBorder(new TitledBorder("Product"));
        boxProduct.add(boxProductList);
        boxProduct.add(boxAddProductList);

        Box boxNewOrder = Box.createVerticalBox();
        JList listNewOrder = new JList();
        listNewOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listNewOrder.setSelectedIndex(0);
        listNewOrder.setVisibleRowCount(5);
        JScrollPane listNewOrderScrollPane = new JScrollPane(listNewOrder);
        boxNewOrder.add(listNewOrderScrollPane);

        Box boxAddOrder = Box.createHorizontalBox();
        boxAddOrder.add(new JLabel("Total: "));
        boxAddOrder.add(new JLabel("0.0"));
        boxAddOrder.add(new JButton("Delete"));
        boxAddOrder.add(new JButton("Buy"));

        Box boxOrderList = Box.createVerticalBox();
        boxOrderList.setBorder(new TitledBorder("Orders"));
          JList listOrder = new JList();
          listOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          listOrder.setSelectedIndex(0);
          listOrder.setVisibleRowCount(5);
          JScrollPane listOrderScrollPane = new JScrollPane(listOrder);
          boxOrderList.add(listOrderScrollPane);
          boxOrderList.add(new JButton("Delete"));

        Box boxOrder = Box.createVerticalBox();
        boxOrder .setBorder(new TitledBorder("New order"));
        boxOrder.add(boxNewOrder);
        boxOrder.add(boxAddOrder);

        Box boxGeneral = Box.createVerticalBox();
        boxGeneral.add(boxClient);
        boxGeneral.add(boxProduct);
        boxGeneral.add(boxOrder);
        boxGeneral.add(boxOrderList);

        setContentPane(boxGeneral);
        pack();
        setResizable(false);
    }
}
