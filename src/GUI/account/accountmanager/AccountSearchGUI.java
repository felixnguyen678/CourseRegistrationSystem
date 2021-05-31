package GUI.account.accountmanager;

import DAO.AccountDAO;
import POJO.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountSearchGUI extends JFrame{
    private JPanel panel;
    private JLabel username;
    private JLabel accountName;
    private JButton editAccountButton;
    private JLabel email;
    private JLabel phoneNumber;
    private JButton removeAccountButton;

    public AccountSearchGUI(Account account) {

        username.setText(account.getUsername());
        accountName.setText(account.getAccountName());
        email.setText(account.getEmail());
        phoneNumber.setText(account.getPhoneNumber());

        add(panel);
        setSize(400, 200);
        setTitle("Add Account");
        setLocationRelativeTo(null);
        setVisible(true);


        editAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                EditAccountGUI editAccountGUI = new EditAccountGUI(account);
            }
        });
        removeAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDAO.removeAccount(account);
                dispose();
                JOptionPane.showMessageDialog(null, "Successfully removed.");
            }
        });
    }
}
