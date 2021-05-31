package GUI.account.accountmanager;

import DAO.AccountDAO;
import POJO.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountGUI extends JFrame{
    private JTextField usernameTextField;
    private JPanel panel;
    private JTextField accountNameTextField;
    private JTextField emailTextField;
    private JTextField phoneNumberTextField;
    private JButton addAccountButton;

    public AddAccountGUI() {
        add(panel);
        setSize(400, 200);
        setTitle("Add Account");
        setLocationRelativeTo(null);
        setVisible(true);


        addAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account account = new Account(
                        usernameTextField.getText(),
                        usernameTextField.getText(),
                        accountNameTextField.getText(),
                        emailTextField.getText(),
                        phoneNumberTextField.getText()
                );
                if(AccountDAO.addAccount(account))
                {
                    JOptionPane.showMessageDialog(null, "Successfully added.");
                }
                else
                    JOptionPane.showMessageDialog(null, "Try another username","Add warning", JOptionPane.WARNING_MESSAGE);

            }
        });
    }
}
