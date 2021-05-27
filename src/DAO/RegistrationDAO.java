package DAO;

import POJO.Registration;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class RegistrationDAO {
    public static List<Registration> getAllRegistrations(){
        Session session = HibernateUtil.getSession();

        List<Registration> registrations = null;
        try{
            final String hql = "select re from Registration re";
            Query query = session.createQuery(hql);

            registrations = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return registrations;
    }
}
