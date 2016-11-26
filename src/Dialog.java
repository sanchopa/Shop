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
        boxClientField.setBorder(new TitledBorder("Client"));
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

        Box boxProductList = Box.createVerticalBox();
        boxProductList.add(createList());

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
        boxNewOrder.add(createList());

        Box boxAddOrder = Box.createHorizontalBox();
        boxAddOrder.add(new JLabel("Total: "));
        boxAddOrder.add(new JLabel("0.0"));
        boxAddOrder.add(new JButton("Delete"));
        boxAddOrder.add(new JButton("Buy"));

        Box boxOrder = Box.createVerticalBox();
        boxOrder .setBorder(new TitledBorder("New order"));
        boxOrder.add(boxNewOrder);
        boxOrder.add(boxAddOrder);

        Box boxOrderList = Box.createVerticalBox();
        boxOrderList.add(createList());

        Box boxOrderEdit = Box.createHorizontalBox();
        boxOrderEdit.add(new JButton("Delete"));

        Box boxOrders = Box.createVerticalBox();
        boxOrders.setBorder(new TitledBorder("Orders"));
        boxOrders.add(boxOrderList);
        boxOrders.add(boxOrderEdit);

        Box boxGeneral = Box.createVerticalBox();
        boxGeneral.add(boxClientField);
        boxGeneral.add(boxProduct);
        boxGeneral.add(boxOrder);
        boxGeneral.add(boxOrders);

        setContentPane(boxGeneral);
        pack();
        setResizable(false);
    }

    private JScrollPane createList() {
        JList jList = new JList();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setSelectedIndex(0);
        jList.setVisibleRowCount(5);
        return new JScrollPane(jList);
    }
}
