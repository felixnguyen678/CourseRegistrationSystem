package DAO;

import POJO.Account;
import POJO.Student;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class AccountDAO {
    public static List<Account> getAllAccounts(){
        Session session = HibernateUtil.getSession();

        List<Account> accounts = null;
        try{
            final String hql = "select acc from Account acc";
            Query query = session.createQuery(hql);

            //get all students
            accounts = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return accounts;
    }
}
