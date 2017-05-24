package com.kind.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.kind.bean.Students;
import com.kind.bean.Users;
import com.kind.dao.IStudentsDao;
import com.kind.service.IStudentsService;

@Repository("studentsDao")
public class StudentsDaoImpl extends BaseDaoImpl<Students> implements IStudentsDao{

	private Session session=null;
	private String hql=null;
	 public List<Students> findAllStudents() {
		session=getSession();
		hql="from Students";
		Query query=session.createQuery(hql);
		List<Students> list=query.list();
		return list;
	}
	public void deletStuById(int id) {
		delete(id);
		
		
	}
	public void update(Students stu) {
		saveOrUpdate(stu);
		
	}
	public Students findStuById(int id) {
		Students student=findById(id);
		return student;
	}
	
	
	
}
