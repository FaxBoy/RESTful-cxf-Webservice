package com.sc.springmvc.dao;


import org.springframework.stereotype.Repository;

import com.sc.springmvc.pojo.User;
import com.sc.springmvc.util.SupportDao;

@Repository
public interface UserDao extends SupportDao<User, String>{
	
    User selectByPrimaryKey(Integer id);
    
}
