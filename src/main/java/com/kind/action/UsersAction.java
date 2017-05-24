package com.kind.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.kind.bean.Users;
import com.kind.service.IUsersService;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport implements
ServletRequestAware, ServletResponseAware, ServletContextAware{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户信息
	private String username;
	private String password;
	
	protected HttpSession session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;
	
	//spring依赖注入
	@Autowired 
	private IUsersService userService;
	
	/**
	 * 登录
	 * @return
	 */
	public String login()
	{
	  String flag="success";
		try {
			Users user=userService.login(username, password);
		    //将登陆成功的用户信息保存到session中
		    session=ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			//System.out.println("username"+user.getUsername());
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			flag="error";
			
		}
		return flag;
		
	}
	/**
	 * 退出登录
	 * @return
	 */
	public String logout()
	{
		session=request.getSession();
		//System.out.println("session="+session.getAttribute("user"));
		if(session.getAttribute("user")!=null)
		{
			session.removeAttribute("user");
		}
		return "logout";
		
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	
}
