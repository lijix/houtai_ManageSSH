package com.kind.dao.Impl;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.kind.bean.Users;
import com.kind.dao.IUsersDao;
@Repository("userDao")
public class UsersDaoImpl extends BaseDaoImpl<Users> implements IUsersDao {
	
	private String hql=null;
	private Session session=null; 
	
	public Users findUserByNameAndPwd(String username, String pwd) {
		session=getSession();
		Users user=null;
		hql="from Users where username=? and password=?";
		Query query= session.createQuery(hql);
		query.setParameter(0 , username);
		query.setParameter(1, pwd);
		 user=(Users) query.uniqueResult();
		return user;

	}  
}
