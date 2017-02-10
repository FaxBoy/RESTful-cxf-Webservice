package com.sc.springmvc.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.sc.springmvc.dao.UserDao;
import com.sc.springmvc.pojo.User;
import com.sc.springmvc.service.UserService;

@Service
public class UserServiceImpl extends ServiceSupportImpl<User, String> implements UserService {
	
	@Resource
	private UserDao userDao;
	
	public User getUserById(int userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}
}