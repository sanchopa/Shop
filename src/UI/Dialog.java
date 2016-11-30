package UI;

import service.Market;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JFrame {
    private JTextField fieldClientName;
    private JTextField fieldClientSurname;
    private JTextField fieldClientPhone;
    private JTextField fieldClientEmail;
    private JTextField fieldClientAddress;
    private JTextField fieldCountProduct;
    private DefaultListModel listModelNewOrder = new DefaultListModel();
    private DefaultListModel listModelOrders  = new DefaultListModel();
    private JLabel labelTotal;
    private JList listProduct;
    private JList listOrder;
    private JList listNewOrder;
    JLabel labelStatus;

    public Dialog(Market market) throws HeadlessException {

        super("Book shop");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        listProduct = createList(market.getStringStorageProducts(),new DefaultListModel());
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
                                                    onBuyOrder(market);
                                                }
                                            });
        boxAddOrder.add(buttonBuyOrder);

        Box boxOrder = Box.createVerticalBox();
        boxOrder .setBorder(new TitledBorder("New order"));
        boxOrder.add(boxNewOrder);
        boxOrder.add(boxAddOrder);

        Box boxOrderList = Box.createVerticalBox();
        listOrder = createList(null, listModelOrders);
        boxOrderList.add(new JScrollPane(listOrder));

        Box boxOrderEdit = Box.createHorizontalBox();
        JButton buttonDeleteOrder = new JButton("Delete");
        buttonDeleteOrder.addMouseListener(new MouseAdapter() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                onDeleteOrder(market);
                                            }
                                        });
        boxOrderEdit.add(buttonDeleteOrder);

        Box boxOrders = Box.createVerticalBox();
        boxOrders.setBorder(new TitledBorder("Orders"));
        boxOrders.add(boxOrderList);
        boxOrders.add(boxOrderEdit);
        labelStatus = new JLabel();
        boxAddOrder.add(labelStatus);

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
        if(index==-1) {
            return;
        }
        labelTotal.setText(market.deleteProductFromOrder(index));
        listModelNewOrder.remove(index);
    }

    private void onAddToOrder(Market market) {
        int selectIndex = listProduct.getSelectedIndex();
        if(selectIndex==-1) {
            return;
        }
        String count = fieldCountProduct.getText();
        listModelNewOrder.addElement((market.addProductToOrder(selectIndex,
                                                Integer.parseInt(count)))+"-"+count+" шт");
        labelTotal.setText(market.getStringOrderPrice());
    }

    private void onBuyOrder(Market market) {

        Object order = market.buyOrder(fieldClientName.getText(), fieldClientSurname.getText(),
                fieldClientEmail.getText(),fieldClientPhone.getText(),
                fieldClientAddress.getText());
        if(order==null) return;
        listModelOrders.addElement(order);
        market.newOrder();
        labelTotal.setText("0.0");
        listModelNewOrder.clear();
    }

    private void onDeleteOrder (Market market) {
        int index = listOrder.getSelectedIndex();
        if(index==-1) {
            return;
        }
        market.deleteOrder(index);
        listModelOrders.remove(index);
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
