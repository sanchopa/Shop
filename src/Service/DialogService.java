package Service;

import javax.swing.*;

public class DialogService {
        public static void movePositionToList(JList firstList, DefaultListModel secondListModel) {
            secondListModel.addElement(firstList.getSelectedValue());
        }
}
