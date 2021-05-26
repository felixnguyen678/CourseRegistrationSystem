package DAO;

import POJO.Account;

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
    public static Account getAccountByUsername(String username){
        Session session = HibernateUtil.getSession();
        Account account = null;
        try{
            final String hql = "select acc from Account acc where acc.id='"+username+"'";
            Query query = session.createQuery(hql);

            //get all students
            List<Account> accounts = query.list();
            account = accounts.get(0);
        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return account;
    }
}
