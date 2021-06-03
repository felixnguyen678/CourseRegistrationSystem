package DAO;

import POJO.Clazz;
import POJO.CourseRegistrationSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class CourseRegistrationSessionDAO {

    public static List<CourseRegistrationSession> getAllCourseRegistrationSession(){
        Session session = HibernateUtil.getSession();

        List<CourseRegistrationSession> courseRegistrationSessions = null;
        try{
            final String hql = "from CourseRegistrationSession";
            Query query = session.createQuery(hql);

            //get all students
            courseRegistrationSessions = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return courseRegistrationSessions;
    }
    public static boolean addCourseRegistrationSession(CourseRegistrationSession c){
        Session session = HibernateUtil.getSession();
        if(ClazzDAO.getClazzById(c.getSemesterId()) != null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
        } catch (HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
        }
        finally{
            session.close();
        }
        return true;

    }
    public static CourseRegistrationSession getCourseRegistrationSessionById(String id){
        Session session = HibernateUtil.getSession();
        CourseRegistrationSession c = null;
        try{
            c = (CourseRegistrationSession) session.get(CourseRegistrationSession.class, id);
        }
        catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return c;
    }

}
