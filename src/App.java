import DAO.AccountDAO;
import GUI.LoginGUI;
import POJO.Account;


import javax.swing.*;
import java.util.List;

public class App {
    public static String userId;
    public static String typeOfUser;

    public static void main(final String[] args) throws Exception {

        //System.out.println("hello");
        //hibernate test
        Account account = AccountDAO.getAccountByUsername("abc");
        System.out.println(account.toString());


        // swing form review
        JFrame.setDefaultLookAndFeelDecorated(true);

        LoginGUI loginGUI = LoginGUI.getInstance();
        //AccountHomeGUI accountHomeGUI = new AccountHomeGUI();
        //GUI.student.StudentHomeGUI studentHomeGUI = new GUI.student.StudentHomeGUI();


    }
}