package com.kind.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.kind.bean.Students;
import com.kind.service.IStudentsService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware,ModelDriven<Students>{

	private ServletContext application;
	private HttpServletResponse response;
	private HttpServletRequest request;
	

	private Students student;
	@Autowired
	private IStudentsService studentsService;

public Students getModel() {
		if(student==null)
		{
			student=new Students();
		}
		return student;
	}

/**
 * 学生列表
 * @return
 */
	public String query()
	{
		List<Students> list=studentsService.findAllStudents();
		System.out.println("studentsList"+list);
		request.setAttribute("studentsList", list);
		return "StudentsQuery";
		
	}
	/**
	 * 跳转到修改学生列表
	 * @return
	 */
	public String toModify()
	{
		int id=Integer.parseInt(request.getParameter("sid"));
		System.out.println("id="+id);
		Students student=studentsService.findStuById(id);
		request.setAttribute("student", student);
		return "toModify";
		
	}
	
	/**
	 * 保存修改
	 * @return
	 */
	public String save(){
		System.out.println("students"+getModel());
	   studentsService.saveOrUpdate(getModel());	
		return "save_success";
		
	}
	
	/**
	 * 删除学生
	 * @param stu 
	 * @return
	 */
	public String delete()
	{
		int id=Integer.parseInt(request.getParameter("sid"));
	//System.out.println("id="+id);
		studentsService.deleteStuById(id);
		return "delete";
		
	}
	public String toAdd()
	{
		return "toAdd";
	}
	public String add()
	{
		studentsService.saveOrUpdate(student);
		return "add_success";
	}
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}
	
}
