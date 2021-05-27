package GUI.account;

import GUI.LoginGUI;
import GUI.student.StudentHomeGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountHomeGUI extends JFrame{
    private JPanel panel;
    private JButton accountButton;
    private JButton subjectButton;
    private JButton semesterButton;
    private JButton clazzButton;
    private JButton studentButton;
    private JButton courseRegistrationSessionButton;
    private JButton courseButton;
    private JButton courseRegistrationResultButton;
    private JButton profileButton;
    private JButton logOutButton;


    public AccountHomeGUI(){
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
    }

}
