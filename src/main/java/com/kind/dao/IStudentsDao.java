package com.kind.dao;

import java.util.List;

import com.kind.bean.Students;

public interface IStudentsDao {
  List<Students> findAllStudents();
   void deletStuById(int id);
   void update(Students stu);
   Students findStuById(int id); 
}
