package GUI.account;

import DAO.AccountDAO;
import GUI.ChangePasswordGUI;
import POJO.Account;
import antlr.StringUtils;
import utils.RunTimeUtil;
import utils.StringUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountProfileManagerGUI extends JFrame{
    private JPanel panel;
    private JLabel username;
    private JLabel accountName;
    private JButton editProfileButton;
    private JButton changePasswordButton;
    private JLabel email;
    private JLabel phoneNumber;

    public AccountProfileManagerGUI(Account account) {

        username.setText(account.getUsername());
        accountName.setText(account.getAccountName());
        email.setText(account.getEmail());
        phoneNumber.setText(account.getPhoneNumber());
        add(panel);
        setSize(400, 200);
        setTitle("Your Profile");
        setLocationRelativeTo(null);
        setVisible(true);


        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AccountProfileEditGUI accountProfileEditGUI = new AccountProfileEditGUI(account);
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ChangePasswordGUI changePasswordGUI = new ChangePasswordGUI();
            }
        });
    }
}
