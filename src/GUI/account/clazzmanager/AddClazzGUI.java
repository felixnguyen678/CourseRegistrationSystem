package GUI.account.clazzmanager;

import DAO.ClazzDAO;
import POJO.Clazz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClazzGUI extends JFrame{
    private JTextField classIdTextField;
    private JTextField classNameTextField;
    private JButton addClassButton;
    private JPanel panel;

    public AddClazzGUI() {

        add(panel);
        setSize(400, 200);
        setTitle("Search Class");
        setLocationRelativeTo(null);
        setVisible(true);

        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ClazzDAO.addClazz(new Clazz(
                        classIdTextField.getText(),
                        classNameTextField.getText())
                )) {
                    JOptionPane.showMessageDialog(null, "Successfully added.");
                }
                else
                    JOptionPane.showMessageDialog(null, "Try another class-id","Add warning", JOptionPane.WARNING_MESSAGE);

            }
        });
    }
}
