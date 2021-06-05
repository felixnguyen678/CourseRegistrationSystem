package DAO;

import POJO.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class CourseDAO {
    public static Course getCourseById(String id){
        Session session = HibernateUtil.getSession();
        Course course = null;
        try{
            course = (Course) session.get(Course.class, id);
        }
        catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return course;
    }
    public static boolean addCourse(Course course){
        Session session = HibernateUtil.getSession();
        if(CourseDAO.getCourseById(course.getCourseId()) != null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(course);
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
    public static boolean removeCourse(Course course){
        Session session = HibernateUtil.getSession();
        if(CourseDAO.getCourseById(course.getCourseId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(course);
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
