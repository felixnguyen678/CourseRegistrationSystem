package GUI.account;

import DAO.AccountDAO;
import GUI.LoginGUI;
import GUI.account.accountmanager.AccountManagerGUI;
import GUI.account.clazzmanager.ClazzManagerGUI;
import GUI.account.profilemanager.ProfileManagerGUI;
import GUI.account.semestermanager.SemesterManagerGUI;
import GUI.account.subjectmanager.SubjectManagerGUI;
import POJO.Account;
import utils.RunTimeUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI extends JFrame{
    private JPanel panel;
    private JButton accountButton;
    private JButton subjectButton;
    private JButton semesterButton;
    private JButton clazzButton;
    private JButton studentButton;
    private JButton courseRegistrationSessionButton;
    private JButton courseButton;
    private JButton courseRegistrationResultButton;
    private JButton yourProfileButton;
    private JButton logOutButton;


    public HomeGUI(){
        add(panel);
        setSize(500, 300);
        setTitle("Home");
        setLocationRelativeTo(null);
        setVisible(true);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI loginGUI = new LoginGUI();
            }
        });
        yourProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Account account = AccountDAO.getAccountByUsername(RunTimeUtil.getUserId());
                ProfileManagerGUI profileManagerGUI = new ProfileManagerGUI(
                        account
                );
            }
        });
        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountManagerGUI accountManagerGUI = new AccountManagerGUI();
            }
        });
        clazzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClazzManagerGUI clazzManagerGUI = new ClazzManagerGUI();
            }
        });
        subjectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubjectManagerGUI subjectManagerGUI = new SubjectManagerGUI();
            }
        });
        semesterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SemesterManagerGUI semesterManagerGUI = new SemesterManagerGUI();
            }
        });
    }

}
