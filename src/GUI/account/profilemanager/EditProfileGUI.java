package GUI.account.profilemanager;

import DAO.AccountDAO;
import POJO.Account;
import utils.RunTimeUtil;
import utils.StringUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfileGUI extends JFrame{
    private JPanel panel;
    private JTextField accountName;
    private JButton submitButton;
    private JTextField email;
    private JTextField phoneNumber;

    public EditProfileGUI(Account account){
        accountName.setText(account.getAccountName());
        email.setText(account.getEmail());
        phoneNumber.setText(account.getPhoneNumber());
        add(panel);
        setSize(400, 200);
        setTitle("Your Profile");
        setLocationRelativeTo(null);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!StringUtil.isLong(phoneNumber.getText())){
                    JOptionPane.showMessageDialog(null, "Phone number is not valid.","Update warning", JOptionPane.WARNING_MESSAGE);
                }
                else if(
                        AccountDAO.updateAccount(new Account(
                            RunTimeUtil.getUserId(),
                            RunTimeUtil.getPassword(),
                            accountName.getText(),
                            email.getText(),
                            phoneNumber.getText()
                ))){
                    JOptionPane.showMessageDialog(null, "Successfully Update.");
                }
                else
                    JOptionPane.showMessageDialog(null, "Something wrong, please try again.","Update warning", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
