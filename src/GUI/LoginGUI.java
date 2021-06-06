package GUI;

import DAO.AccountDAO;
import DAO.StudentDAO;
import GUI.student.HomeGUI;
import POJO.Account;

import POJO.Student;
import utils.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                        RunTimeUtil.setTypeOfUser("account");
                        RunTimeUtil.setPassword(String.valueOf(passwordField.getPassword()));
                        RunTimeUtil.setUserId(textField.getText());
                        dispose();
                        GUI.account.HomeGUI homeGUI = new GUI.account.HomeGUI();

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
                            RunTimeUtil.setTypeOfUser("student");
                            RunTimeUtil.setPassword(String.valueOf(passwordField.getPassword()));
                            RunTimeUtil.setUserId(textField.getText());
                            dispose();
                            HomeGUI homeGUI = new HomeGUI(student);
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
