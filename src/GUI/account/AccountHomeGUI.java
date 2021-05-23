package GUI.account;

import javax.swing.*;

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
    }

}
