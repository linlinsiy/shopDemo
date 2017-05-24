package com.lsy.shop.user.dao;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lsy.shop.user.pojo.User;

public class UserDao extends HibernateDaoSupport{

	//按照名称查询是否有该用户
	public User findByUsername(String username){
		String hql = "from User where username = ?";
		@SuppressWarnings("unchecked")
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 注册用户存入数据库
	 * @param user
	 */
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user) {
		String hql = "from User where username = ? and password = ?";
		@SuppressWarnings("unchecked")
		List<User> list = getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	

}
