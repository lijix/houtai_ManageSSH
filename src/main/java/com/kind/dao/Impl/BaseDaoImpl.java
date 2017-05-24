package com.kind.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.kind.dao.BaseDao;

public class BaseDaoImpl<M> implements BaseDao<M> {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	public void save(M model) {
		getSession().save(model);
	}

	public void saveOrUpdate(M model) {
		getSession().saveOrUpdate(model);
	}

	public void deleteObject(M model) {
		getSession().delete(model);
	}

	public void merge(M model) {
		getSession().merge(model);
	}

	public void delete(int id) {
		getSession().delete(this.findById(id));
	}

	public boolean exists(long id) {
		// TODO Auto-generated method stub
		return findById(id)!=null;
	}

	public M findById(int id) {
		// TODO Auto-generated method stub
		return (M) getSession().get(this.getEntityClass(), id);
	}

	public Class<M> getEntityClass(){
		ParameterizedType parameterizedType=(ParameterizedType)(getClass().getGenericSuperclass());
		return (Class<M>)(parameterizedType.getActualTypeArguments()[0]);
	}
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	public M findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
