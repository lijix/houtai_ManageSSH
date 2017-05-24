package com.kind.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kind.bean.Students;
import com.kind.dao.IStudentsDao;
import com.kind.service.IStudentsService;
@Service
public class StudentsServiceImpl implements IStudentsService{
	@Autowired
	@SuppressWarnings("unused")
	private IStudentsDao studentsDao;
	
	public List<Students> findAllStudents() {
		
		return studentsDao.findAllStudents();
	}

	public void deleteStuById(int id) {
		studentsDao.deletStuById(id);
	}

	public void modify(Students stu) {
		studentsDao.update(stu);
	}

	public Students findStuById(int id) {
		
		return studentsDao.findStuById(id);
	}

	public void saveOrUpdate(Students stu) {
		studentsDao.update(stu);
	}

	

	

}
