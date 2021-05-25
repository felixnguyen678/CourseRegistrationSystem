import DAO.AccountDAO;
import POJO.Account;

import java.util.List;

public class App {


    public static void main(final String[] args) throws Exception {

        //System.out.println("hello");
        //hibernate test
        List<Account> accounts = AccountDAO.getAllAccounts();
        if(accounts.size() == 0 ) System.out.println("dm");
        for(Account item: accounts)
            System.out.println(item.toString());



        /*
        // swing form review
        JFrame.setDefaultLookAndFeelDecorated(true);
        //LoginGUI loginGUI = new LoginGUI();
        //AccountHomeGUI accountHomeGUI = new AccountHomeGUI();
        GUI.student.StudentHomeGUI studentHomeGUI = new GUI.student.StudentHomeGUI();

         */
    }
}