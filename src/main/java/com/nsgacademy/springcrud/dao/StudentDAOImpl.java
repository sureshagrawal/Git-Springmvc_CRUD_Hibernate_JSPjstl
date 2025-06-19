package com.nsgacademy.springcrud.dao;

import com.nsgacademy.springcrud.exception.DAOException;
import com.nsgacademy.springcrud.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Student student) {
        try {
            getSession().persist(student);
        } catch (Exception e) {
            throw new DAOException("Error saving student", e);
        }
    }

    @Override
    public Student findById(int id) {
        try {
            return getSession().find(Student.class, id);
        } catch (Exception e) {
            throw new DAOException("Error finding student with ID: " + id, e);
        }
    }

    @Override
    public List<Student> findAll() {
        try {
            return getSession().createQuery("FROM Student", Student.class).getResultList();
        } catch (Exception e) {
            throw new DAOException("Error retrieving student list", e);
        }
    }

    @Override
    public void update(Student student) {
        try {
            getSession().merge(student);
        } catch (Exception e) {
            throw new DAOException("Error updating student", e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Student student = getSession().find(Student.class, id);
            if (student != null) {
                getSession().remove(student);
            }
        } catch (Exception e) {
            throw new DAOException("Error deleting student with ID: " + id, e);
        }
    }

}
