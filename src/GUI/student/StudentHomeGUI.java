package GUI.student;

import javax.swing.*;

public class StudentHomeGUI extends JFrame{
    private JButton courseRegistrationButton;
    private JButton yourRegistrationButton;
    private JButton yourProfileButton;
    private JButton logOutButton;
    private JPanel panel;

    public StudentHomeGUI(){
        add(panel);
        setSize(300, 300);
        setTitle("Home");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
