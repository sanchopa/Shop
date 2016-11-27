package UI;

import Service.DataLoader;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JFrame {
    JTextField fieldCountProduct;

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
        JList listProduct = createList(DataLoader.getArrayProduct());
        boxProductList.add(new JScrollPane(listProduct));

        Box boxAddProductList = Box.createHorizontalBox();
        boxAddProductList.add(new JLabel("Count:"));
        fieldCountProduct = new JTextField(3);
        fieldCountProduct.setMaximumSize(fieldCountProduct.getPreferredSize());
        fieldCountProduct.setText("1");
        boxAddProductList.add(fieldCountProduct);
        JButton buttonAddOrder = new JButton("Add to order");
        buttonAddOrder.addMouseListener(new MouseAdapter() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                System.out.println("Add to order");
                                            }
                                        });
        boxAddProductList.add(buttonAddOrder);

        Box boxProduct = Box.createVerticalBox();
        boxProduct.setBorder(new TitledBorder("Product"));
        boxProduct.add(boxProductList);
        boxProduct.add(boxAddProductList);

        Box boxNewOrder = Box.createVerticalBox();
        JList listNewOrder = createList(null);
        boxNewOrder.add(new JScrollPane(listNewOrder));

        Box boxAddOrder = Box.createHorizontalBox();
        boxAddOrder.add(new JLabel("Total: "));
        boxAddOrder.add(new JLabel("0.0"));

        JButton buttonDeletePosition = new JButton("Delete");
        buttonDeletePosition.addMouseListener(new MouseAdapter() {
                                                @Override
                                                public void mouseClicked(MouseEvent e) {
                                                    System.out.println("Delete");
                                                }
                                            });
        boxAddOrder.add(buttonDeletePosition);

        JButton buttonBuyOrder = new JButton("Buy");
        buttonBuyOrder.addMouseListener(new MouseAdapter() {
                                                @Override
                                                public void mouseClicked(MouseEvent e) {
                                                    System.out.println("Buy");
                                                }
                                            });
        boxAddOrder.add(buttonBuyOrder);

        Box boxOrder = Box.createVerticalBox();
        boxOrder .setBorder(new TitledBorder("New order"));
        boxOrder.add(boxNewOrder);
        boxOrder.add(boxAddOrder);

        Box boxOrderList = Box.createVerticalBox();
        JList listOrder = createList(null);
        boxOrderList.add(new JScrollPane(listOrder));

        Box boxOrderEdit = Box.createHorizontalBox();
        JButton buttonDeleteOrder = new JButton("Delete");
        buttonDeleteOrder.addMouseListener(new MouseAdapter() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                System.out.println("Delete");
                                            }
                                        });
        boxOrderEdit.add(buttonDeleteOrder);

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

    private JList createList(Object[] listData) {
        JList jList = new JList();
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setSelectedIndex(0);
        jList.setVisibleRowCount(5);
        if(listData!=null)
            jList.setListData(listData);
        return jList;
    }
}
