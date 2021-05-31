package DAO;

import POJO.Subject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class SubjectDAO {
    public static List<Subject> getAllSubjects() {
        Session session = HibernateUtil.getSession();

        List<Subject> subjects = null;
        try{
            final String hql = "select sj from Subject sj";
            Query query = session.createQuery(hql);

            //get all students
            subjects = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return subjects;
    }
    public static Subject getSubjectById(String id){
        Session session = HibernateUtil.getSession();
        Subject subject = null;
        try{
            subject = (Subject) session.get(Subject.class, id);
        }
        catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return subject;
    }
    public static boolean updateSubject(Subject subject){
        Session session = HibernateUtil.getSession();
        if(SubjectDAO.getSubjectById(subject.getSubjectId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(subject);
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
    public static boolean addSubject(Subject subject){
        Session session = HibernateUtil.getSession();
        if(SubjectDAO.getSubjectById(subject.getSubjectId()) != null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(subject);
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
    public static boolean removeSubject(Subject subject){
        Session session = HibernateUtil.getSession();
        if(SubjectDAO.getSubjectById(subject.getSubjectId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(subject);
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
}
