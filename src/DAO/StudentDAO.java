package DAO;

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
}
