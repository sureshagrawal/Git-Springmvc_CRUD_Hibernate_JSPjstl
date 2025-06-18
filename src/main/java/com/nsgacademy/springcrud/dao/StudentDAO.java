package com.nsgacademy.springcrud.dao;

import com.nsgacademy.springcrud.model.Student;

import java.util.List;

public interface StudentDAO {
    void insertStudent(Student student);
    Student selectStudent(int id);
    List<Student> selectAllStudents();
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
}


