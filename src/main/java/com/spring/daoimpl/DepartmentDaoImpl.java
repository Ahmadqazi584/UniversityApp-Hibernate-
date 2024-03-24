package com.spring.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.dao.DepartmentDao;
import com.spring.model.Department;

public class DepartmentDaoImpl implements DepartmentDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(Department department) {
        hibernateTemplate.save(department);
    }

    @Override
    public Department findById(int id) {
        return hibernateTemplate.get(Department.class, id);
    }

    @Override
    public List<Department> findAll() {
        return hibernateTemplate.loadAll(Department.class);
    }

    @Override
    public void update(Department department) {
        hibernateTemplate.update(department);
    }

    @Override
    public void delete(Department department) {
        hibernateTemplate.delete(department);
    }
}
