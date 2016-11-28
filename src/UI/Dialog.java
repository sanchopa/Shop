package UI;

import Model.Market;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JFrame {
    private static JTextField fieldClientName;
    private static JTextField fieldClientSurname;
    private static JTextField fieldClientPhone;
    private static JTextField fieldClientEmail;
    private static JTextField fieldClientAddress;

    private JTextField fieldCountProduct;
    private DefaultListModel listModelNewOrder;
    private JLabel labelTotal;
    private JList listProduct;
    private  JList listOrder;
    private   JList listNewOrder;

    public Dialog(Market market) throws HeadlessException {

        super("Book shop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Box boxClientField = Box.createHorizontalBox();
        boxClientField.setBorder(new TitledBorder("Client"));
        boxClientField.add(new JLabel("Name:"));
        fieldClientName = new JTextField(10);
        boxClientField.add(fieldClientName);
        boxClientField.add(new JLabel("Surname:"));
        fieldClientSurname = new JTextField(10);
        boxClientField.add(fieldClientSurname);
        boxClientField.add(new JLabel("Phone num.:"));
        fieldClientPhone = new JTextField(10);
        boxClientField.add(fieldClientPhone);
        boxClientField.add(new JLabel("E-mail:"));
        fieldClientEmail = new JTextField(10);
        boxClientField.add(fieldClientEmail);
        boxClientField.add(new JLabel("Address:"));
        fieldClientAddress = new JTextField(10);
        boxClientField.add(fieldClientAddress);

        Box boxProductList = Box.createVerticalBox();
        listProduct = createList(market.getStringStorageGoods(),new DefaultListModel());
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
                                                onAddToOrder(market);
                                            }
                                        });
        boxAddProductList.add(buttonAddOrder);

        Box boxProduct = Box.createVerticalBox();
        boxProduct.setBorder(new TitledBorder("Product"));
        boxProduct.add(boxProductList);
        boxProduct.add(boxAddProductList);

        Box boxNewOrder = Box.createVerticalBox();
        listModelNewOrder = new DefaultListModel();
        listNewOrder = createList(null, listModelNewOrder);
        boxNewOrder.add(new JScrollPane(listNewOrder));

        Box boxAddOrder = Box.createHorizontalBox();
        boxAddOrder.add(new JLabel("Total: "));
        labelTotal = new JLabel("0.0");
        boxAddOrder.add(labelTotal);

        JButton buttonDeletePosition = new JButton("Delete");
        buttonDeletePosition.addMouseListener(new MouseAdapter() {
                                                @Override
                                                public void mouseClicked(MouseEvent e) {
                                                    onProductDelete(market);
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
        listOrder = createList(null, new DefaultListModel());
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

    private void onProductDelete(Market market) {
        int index = listNewOrder.getSelectedIndex();
        labelTotal.setText(market.deleteProductFromOrder(index));
        listModelNewOrder.remove(index);
    }

    private void onAddToOrder(Market market) {
        String count = fieldCountProduct.getText();
        listModelNewOrder.addElement((market.addProductToOrder(listProduct.getSelectedIndex(), Integer.parseInt(count)))+count+"шт");
        labelTotal.setText(market.getTotalSum());
    }

    private JList createList(Object[] listData, DefaultListModel listModel) {
        JList jList = new JList(listModel);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setSelectedIndex(0);
        jList.setVisibleRowCount(5);
        if(listData!=null)
            jList.setListData(listData);
        return jList;
    }
}
