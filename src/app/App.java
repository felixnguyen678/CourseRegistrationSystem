package app;

import DAO.AccountDAO;
import DAO.ClazzDAO;
import DAO.StudentDAO;
import GUI.LoginGUI;
import POJO.Account;
import POJO.Clazz;
import POJO.Student;
import org.hibernate.Session;
import utils.HibernateUtil;


import javax.swing.*;
import java.util.List;

public class App {
    public static String userId;
    public static String typeOfUser;
    public static Session session;

    public static void main(final String[] args) throws Exception {

        //System.out.println("hello");
        //hibernate test
/*
        List<Clazz> clazzes = ClazzDAO.getAllClazz();
        for(Clazz item: clazzes)
            System.out.println(item.toString());

        List<Student> students = StudentDAO.getAllStudents();
        for(Student item: students)
            System.out.printf(item.toString());

        List<Account> accounts = AccountDAO.getAllAccounts();
        for(Account item: accounts)
            System.out.println(item.toString());

 */
        // swing form review
        session = HibernateUtil.getSession();
        JFrame.setDefaultLookAndFeelDecorated(true);

        LoginGUI loginGUI = new LoginGUI();
        //AccountHomeGUI accountHomeGUI = new AccountHomeGUI();
        //GUI.student.StudentHomeGUI studentHomeGUI = new GUI.student.StudentHomeGUI();

        session.close();

    }
}