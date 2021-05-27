package GUI;

import DAO.AccountDAO;
import DAO.StudentDAO;
import GUI.account.AccountHomeGUI;
import GUI.student.StudentHomeGUI;
import POJO.Account;

import POJO.Student;
import app.App;
import com.mysql.cj.log.Log;
import utils.HibernateUtil;

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


    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
    public LoginGUI(){

        add(panel);
        setSize(400, 200);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account account = AccountDAO.getAccountByUsername(textField.getText());
                if(account != null){
                    if(account.getPassword().compareTo(
                            String.valueOf(
                                    passwordField.getPassword()
                            )) == 0){
                        App.userId = textField.getText();
                        App.typeOfUser = "account";
                        dispose();
                        AccountHomeGUI accountHomeGUI = new AccountHomeGUI();
                    }
                    else
                        JOptionPane.showMessageDialog(
                                null,
                                "Wrong username or password",
                                "Login failed",
                                JOptionPane.WARNING_MESSAGE);

                }else {
                    Student student = StudentDAO.getStudentById(textField.getText());
                    if(student != null){
                        if(student.getPassword().compareTo(
                                String.valueOf(passwordField.getPassword())
                        ) == 0){
                            App.userId = textField.getText();
                            App.typeOfUser = "student";
                            dispose();
                            StudentHomeGUI studentHomeGUI = new StudentHomeGUI();
                        }
                        else
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Wrong username or password",
                                    "Login failed",
                                    JOptionPane.WARNING_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(
                                null,
                                "Wrong username or password",
                                "Login failed",
                                JOptionPane.WARNING_MESSAGE);                }
            }
        });
    }

}
