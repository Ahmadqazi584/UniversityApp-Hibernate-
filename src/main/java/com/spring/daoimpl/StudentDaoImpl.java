package com.spring.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.dao.DepartmentDao;
import com.spring.dao.StudentDao;
import com.spring.model.Department;
import com.spring.model.Student;

public class StudentDaoImpl implements StudentDao{
	
	private SessionFactory sessionFactory;
	private DepartmentDao myCustomDepartmentDao;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setMyCustomDepartmentDao(DepartmentDao myCustomDepartmentDao) {
        this.myCustomDepartmentDao = myCustomDepartmentDao;
    }

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(student);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(student);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(student);
		tx.commit();
		session.close();
	}

	@Override
	public Student findById(int studentId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Student student = session.get(Student.class, studentId);
		tx.commit();
		session.close();
		return student;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		studentList = session.createQuery("From Student").list();
		tx.commit();
		session.close();
		return studentList;	
		
	}
}
