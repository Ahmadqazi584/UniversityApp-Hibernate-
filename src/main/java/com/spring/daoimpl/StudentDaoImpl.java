package com.spring.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.dao.DepartmentDao;
import com.spring.dao.StudentDao;
import com.spring.model.Department;
import com.spring.model.Student;

public class StudentDaoImpl implements StudentDao{
	
	private HibernateTemplate hibernateTemplate;
	private DepartmentDao myCustomDepartmentDao;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void setMyCustomDepartmentDao(DepartmentDao myCustomDepartmentDao) {
        this.myCustomDepartmentDao = myCustomDepartmentDao;
    }

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(student);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(student);
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(student);
	}

	@Override
	public Student findById(int studentId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Student.class, studentId);
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Student.class);
		
	}
}
