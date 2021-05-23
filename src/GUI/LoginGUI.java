package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame{
    private JPasswordField passwordField;
    private JTextField textField;
    private JButton loginButton;
    private JPanel panel;

    public LoginGUI(){
        add(panel);
        setSize(400, 200);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
