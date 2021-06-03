package DAO;

import POJO.Account;
import POJO.Clazz;
import POJO.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class StudentDAO {
    public static List<Student> getAllStudents(){
        Session session = HibernateUtil.getSession();

        List<Student> students = null;
        try{
            final String hql = "select st from Student st";
            Query query = session.createQuery(hql);

            //get all students
            students = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return students;
    }
    public static Student getStudentById(String id){
        Session session = HibernateUtil.getSession();
        Student student = null;
        try{
            final String hql = "select st from Student st where st.studentId='"+id+"'";
            Query query = session.createQuery(hql);

            //get all students
            List<Student> students = query.list();
            if(students.size() != 0)
                student = students.get(0);
        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return student;
    }
    public static List<Student> getAllStudentsByClass(Clazz clazz){
        Session session = HibernateUtil.getSession();
        List<Student> students = null;
        try{
            final String hql = "select st from Student st where st.clazz =: clazz";
            Query query = session.createQuery(hql);
            query.setParameter("clazz", clazz);

            //get all students
            students = query.list();
        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return students;
    }
    public static boolean updateStudent(Student student){
        Session session = HibernateUtil.getSession();
        if(StudentDAO.getStudentById(student.getStudentId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(student);
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
    public static boolean insertStudent(Student student){
        Session session = HibernateUtil.getSession();
        if(StudentDAO.getStudentById(student.getStudentId()) != null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(student);
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
