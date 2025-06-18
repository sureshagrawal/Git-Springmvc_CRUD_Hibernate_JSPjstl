package com.nsgacademy.springcrud.dao;

import com.nsgacademy.springcrud.exception.DAOException;
import com.nsgacademy.springcrud.model.Student;
import com.nsgacademy.springcrud.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    @Override
    public void insertStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new DAOException("Error inserting student", e);
        }
    }

    @Override
    public Student selectStudent(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Student.class, id);
        } catch (HibernateException e) {
            throw new DAOException("Error retrieving student with ID: " + id, e);
        }
    }

    @Override
    public List<Student> selectAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        } catch (HibernateException e) {
            throw new DAOException("Error retrieving student list", e);
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(student);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new DAOException("Error updating student", e);
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Student student = session.find(Student.class, id);
            if (student != null) {
                session.remove(student);
                tx.commit();
                return true;
            } else {
                if (tx != null) tx.rollback();
                return false;
            }
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw new DAOException("Error deleting student with ID: " + id, e);
        }
    }
}
