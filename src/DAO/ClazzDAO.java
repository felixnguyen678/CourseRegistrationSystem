package DAO;

import POJO.*;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class ClazzDAO {
    public static List<Clazz> getAllClazzes() {
        Session session = HibernateUtil.getSession();

        List<Clazz> clazzes = null;
        try{
            final String hql = "select cl from Clazz cl";
            Query query = session.createQuery(hql);

            //get all students
            clazzes = query.list();

        }
        catch (Throwable ex){
            System.err.println(ex);
        } finally {
            session.close();
        }
        return clazzes;
    }
    public static Clazz getClazzById(String id){
        Session session = HibernateUtil.getSession();
        Clazz clazz = null;
        try{
            clazz = (Clazz) session.get(Clazz.class, id);
        }
        catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return clazz;
    }
    public static boolean updateClazz(Clazz clazz){
        Session session = HibernateUtil.getSession();
        if(ClazzDAO.getClazzById(clazz.getClassId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(clazz);
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
    public static boolean addClazz(Clazz clazz){
        Session session = HibernateUtil.getSession();
        if(ClazzDAO.getClazzById(clazz.getClassId()) != null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(clazz);
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
    public static boolean removeClazz(Clazz clazz){
        Session session = HibernateUtil.getSession();
        if(ClazzDAO.getClazzById(clazz.getClassId()) == null)
            return false;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(clazz);
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
