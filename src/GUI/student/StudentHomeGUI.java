package GUI.student;

import GUI.LoginGUI;
import POJO.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentHomeGUI extends JFrame{
    private JButton courseRegistrationButton;
    private JButton yourRegistrationButton;
    private JButton yourProfileButton;
    private JButton logOutButton;
    private JPanel panel;


    public StudentHomeGUI(Student student){
        add(panel);
        setSize(300, 300);
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
