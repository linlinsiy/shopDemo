package com.lsy.shop.index.action;

import javax.xml.ws.Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页action
 * @author lsy
 *
 */
public class IndexAction extends ActionSupport {

	/**
	 * 执行访问首页方法
	 */
	public String execute(){
		return "index";
	}
	
}
