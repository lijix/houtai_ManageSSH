package com.kind.service;

import java.util.List;

import com.kind.bean.Students;

public interface IStudentsService {
   List<Students> findAllStudents();
   void deleteStuById(int id);
   void modify(Students stu);
   Students findStuById(int id);
   void saveOrUpdate(Students stu);
   
}
