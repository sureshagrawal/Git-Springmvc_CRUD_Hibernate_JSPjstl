package com.nsgacademy.springcrud.dao;

import com.nsgacademy.springcrud.model.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    void update(Student student);
    void delete(int id);
}


