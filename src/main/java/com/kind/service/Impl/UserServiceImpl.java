package com.kind.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kind.bean.Users;
import com.kind.dao.IUsersDao;
import com.kind.dao.Impl.BaseDaoImpl;
import com.kind.service.IUsersService;
@Service
public class UserServiceImpl extends BaseDaoImpl<Users> implements IUsersService{
	@Autowired
	private IUsersDao userDao;
	
	public Users login(String username, String password) {
		
		return userDao.findUserByNameAndPwd(username, password);
	}

}
