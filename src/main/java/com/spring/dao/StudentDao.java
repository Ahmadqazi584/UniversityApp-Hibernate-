package com.spring.dao;

import java.util.List;

import com.spring.model.Student;


public interface StudentDao {
	void save(Student student);
    void update(Student student);
    void delete(Student student);
    Student findById(int studentId);
    List<Student> getAll();
}
