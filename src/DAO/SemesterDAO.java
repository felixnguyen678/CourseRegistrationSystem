package DAO;

import POJO.Semester;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class SemesterDAO {
    public static List<Semester> getAllSemesters() {
        Session session = HibernateUtil.getSession();

        List<Semester> semesters = null;
        try{
            final String hql = "select sm from Semester sm";
            Query query = session.createQuery(hql);

            //get all students
            semesters = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return semesters;
    }
    public static List<Semester> getCurrentSemesters() {
        Session session = HibernateUtil.getSession();

        List<Semester> semesters = null;
        try{
            final String hql = "select sm from Semester sm where sm.isCurrent = 1";
            Query query = session.createQuery(hql);

            //get all students
            semesters = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return semesters;
    }
    public static Semester getSemesterById(String id){
        Session session = HibernateUtil.getSession();
        Semester semester = null;
        try{
            semester = (Semester) session.get(Semester.class, id);
        }
        catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return semester;
    }
    public static boolean updateSemester(Semester semester){
        Session session = HibernateUtil.getSession();
        if(SemesterDAO.getSemesterById(semester.getSemesterId()) == null)
            return false;
        if(semester.getIsCurrent() == 1){
            currentOffSemester();
        }
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(semester);
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
    public static boolean addSemester(Semester semester){
        Session session = HibernateUtil.getSession();
        if(SemesterDAO.getSemesterById(semester.getSemesterId()) != null)
            return false;
        if(semester.getIsCurrent() == 1){
            currentOffSemester();
        }
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(semester);
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
    public static boolean removeSemester(Semester semester){
        Session session = HibernateUtil.getSession();
        if(SemesterDAO.getSemesterById(semester.getSemesterId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(semester);
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
    public static int currentOffSemester(){
        Session session = HibernateUtil.getSession();
        int result = 0;
        List<Semester> semesters = getCurrentSemesters();
        for( Semester i : semesters) {
            i.setIsCurrent((byte) 0);
            updateSemester(i);
            result += 1;
        }
        return result;
    }

}
