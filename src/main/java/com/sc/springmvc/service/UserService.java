package com.sc.springmvc.service;


import com.sc.springmvc.pojo.User;

public interface UserService extends ServiceSupport<User, String>{
	
	public User getUserById(int userId);
	
}
