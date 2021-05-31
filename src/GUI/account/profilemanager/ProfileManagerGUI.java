package GUI.account.profilemanager;

import GUI.ChangePasswordGUI;
import POJO.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileManagerGUI extends JFrame{
    private JPanel panel;
    private JLabel username;
    private JLabel accountName;
    private JButton editProfileButton;
    private JButton changePasswordButton;
    private JLabel email;
    private JLabel phoneNumber;

    public ProfileManagerGUI(Account account) {

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
                EditProfileGUI editProfileGUI = new EditProfileGUI(account);
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
