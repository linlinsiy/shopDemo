package com.lsy.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.lsy.shop.user.dao.UserDao;
import com.lsy.shop.user.pojo.User;
import com.lsy.shop.utils.UUIDUtils;

@Transactional
public class UserService {
	//注入UserDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//按用户名查询用户的方法
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	//业务层完成用户注册
	public void save(User user) {
		//将数据存入数据库
		user.setState(0);//0：代表用户未激活  1：已激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		
	}

	public User login(User user) {
		return userDao.login(user);
	}
}
