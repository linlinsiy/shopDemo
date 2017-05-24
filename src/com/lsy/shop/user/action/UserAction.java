package com.lsy.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lsy.shop.user.pojo.User;
import com.lsy.shop.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户action
 * @author lsy
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user= new User();
	
	//注入service
	private UserService userService;	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 跳转到注册页面的方法
	 */
	public String registPage(){
		return "registPage";
	}
	
	/**
	 * AJAX异步校验
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		//调用service进行查询
		User existUser = userService.findByUsername(user.getUsername());
		//获得response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if(existUser!=null){
			//用户名已存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else{
			//用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}

	/**
	 * 用户注册方法
	 * 数据校验
	 */
	public String regist(){
		userService.save(user);
		this.addActionMessage("注册成功！");
		return "msg";
	}
	
	/**
	 * 跳转登录界面
	 * @return
	 */
	public String loginPage(){
		return "loginPage";
	}
	
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		User existUser = userService.login(user);
		if(existUser == null){
			this.addActionError("登录失败");
			return LOGIN;
		}else {
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
		}
		return "loginSuccess";
	}
	
	/**
	 * 用户退出
	 * @return
	 */
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	/**
	 * 模型驱动要使用的对象
	 */
	@Override
	public User getModel() {
		return user;
	}
}
