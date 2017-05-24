package com.kind.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.client.support.HttpAccessor;

import com.kind.bean.Users;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("user");
		if(user!=null){
		return invocation.invoke();	
		}
		return "toLogin";
	}

}
