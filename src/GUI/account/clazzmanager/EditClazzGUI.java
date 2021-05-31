package GUI.account.clazzmanager;

import DAO.AccountDAO;
import DAO.ClazzDAO;
import POJO.Account;
import POJO.Clazz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClazzGUI extends  JFrame{
    private JPanel panel;
    private JTextField classNameTextField;
    private JButton submitButton;

    public EditClazzGUI(Clazz clazz) {
        classNameTextField.setText(clazz.getClassName());
        add(panel);
        setSize(400, 200);
        setTitle("Edit Account");
        setLocationRelativeTo(null);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clazz updateClazz = ClazzDAO.getClazzById(clazz.getClassId());
                updateClazz.setClassName(classNameTextField.getText());
                if(ClazzDAO.updateClazz(updateClazz)){
                    JOptionPane.showMessageDialog(null, "Successfully Update.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something wrong, please try again.", "Update warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
