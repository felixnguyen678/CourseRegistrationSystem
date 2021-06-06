package DAO;

import POJO.*;
import POJO.Registration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.ArrayList;
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
    public static Registration getRegistrationById(String id){
        Session session = HibernateUtil.getSession();
        Registration regis = null;
        try{
            regis = (Registration) session.get(Registration.class, id);
        }
        catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return regis;
    }
    public static boolean addRegistration(Registration registration){
        Session session = HibernateUtil.getSession();
        if(RegistrationDAO.getRegistrationById(registration.getRegistrationId()) != null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(registration);
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
    public static boolean removeRegistration(Registration registration){
        Session session = HibernateUtil.getSession();
        if(RegistrationDAO.getRegistrationById(registration.getRegistrationId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(registration);
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
    public static List<Registration> getRegistrationsByStudentAndSemester(Student st, Semester se){
        Session session = HibernateUtil.getSession();

        List<Registration> registrations = new ArrayList<Registration>();
        try{
            final String hql = "select re from Registration re where re.student=:student and re.course.semester=:semester";
            Query query = session.createQuery(hql);
            query.setParameter("student", st);
            query.setParameter("semester", se);

            registrations = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return registrations;
    }
    public static Registration getRegistrationByStudentAndCourse(Student st, Course co){
        Session session = HibernateUtil.getSession();

        List<Registration> registrations = new ArrayList<Registration>();
        try{
            final String hql = "select re from Registration re where re.student=:student and re.course=:course";
            Query query = session.createQuery(hql);
            query.setParameter("student", st);
            query.setParameter("course", co);

            registrations = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return registrations.get(0);
    }

}
