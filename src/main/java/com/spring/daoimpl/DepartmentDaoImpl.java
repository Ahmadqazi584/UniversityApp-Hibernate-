package com.spring.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.spring.dao.DepartmentDao;
import com.spring.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(department);
		tx.commit();
		session.close();
	}

	@Override
	public Department findById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Department department = session.get(Department.class, id);
		tx.commit();
		session.close();
		return department;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
	    List<Department> departmentList = new ArrayList<>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		departmentList = session.createQuery("From Department").list();
		tx.commit();
		session.close();
		return departmentList;
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(department);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(department);
		tx.commit();
		session.close();
	}

}
