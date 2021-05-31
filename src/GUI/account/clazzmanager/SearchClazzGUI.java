package GUI.account.clazzmanager;

import DAO.AccountDAO;
import DAO.ClazzDAO;
import POJO.Clazz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchClazzGUI extends JFrame{
    private JButton editButton;
    private JButton removeButton;
    private JPanel panel;
    private JLabel classIdLabel;
    private JLabel classNameLabel;

    public SearchClazzGUI(Clazz clazz) {
        classIdLabel.setText(clazz.getClassId());
        classNameLabel.setText(clazz.getClassName());

        add(panel);
        setSize(400, 200);
        setTitle("Search Class");
        setLocationRelativeTo(null);
        setVisible(true);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClazzDAO.removeClazz(clazz);
                dispose();
                JOptionPane.showMessageDialog(null, "Successfully removed.");
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditClazzGUI editClazzGUI = new EditClazzGUI(clazz);
            }
        });
    }
}
