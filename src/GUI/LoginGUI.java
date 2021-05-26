package GUI;

import DAO.AccountDAO;
import GUI.account.AccountHomeGUI;
import POJO.Account;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginGUI extends JFrame{
    private JPasswordField passwordField;
    private JTextField textField;
    private JButton loginButton;
    private JPanel panel;

    // singleton
    private static final LoginGUI instance = new LoginGUI();

    public static LoginGUI getInstance() {
        return instance;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
    private LoginGUI(){

        add(panel);
        setSize(400, 200);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account account = AccountDAO.getAccountByUsername(textField.getText());
                if(account != null && account.getPassword().compareTo(
                        String.valueOf(
                                passwordField.getPassword()
                        )) == 0){
                    setVisible(false);
                    AccountHomeGUI accountHomeGUI = new AccountHomeGUI();
                }else {

                    JOptionPane.showMessageDialog(null, "Wrong username or password", "Login failed", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

}
