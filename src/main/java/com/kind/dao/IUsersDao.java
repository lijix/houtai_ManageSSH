package com.kind.dao;

import com.kind.bean.Users;

public interface IUsersDao extends BaseDao<Users> {
    public Users findUserByNameAndPwd(String username,String pwd); 
}
