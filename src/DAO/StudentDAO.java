package DAO;

import POJO.Account;
import POJO.Student;
import org.hibernate.Session;
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
}
