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
public class StudentDAOImpl implements StudentDAO {

    @Override
    public void save(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        } catch (HibernateException e) {
            throw new DAOException("Error saving student", e);
        }
    }

    @Override
    public Student findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    @Override
    public void update(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(student);
            tx.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) session.remove(student);
            tx.commit();
        }
    }
}
