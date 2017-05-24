package com.lsy.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author lsy
 *
 */
public class MailUtils {
	/**
	 * 发送邮件的方法
	 * @param to
	 * @param code
	 */
	public static void sendMail(String to,String code){
		//1.获得一个session对象
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("service@shop.com", "service");
			}
			
		});
		//2.创建一个代表邮件的对象message
		Message message = new MimeMessage(session);		
		try {
			//设置发件人
			message.setFrom(new InternetAddress("service@shop.com"));
			//设置收件人
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//设置标题
			message.setSubject("激活邮件");
			//设置正文
			message.setContent("<h1>激活邮件，请点击链接</h1><a href=''>ip地址</a>", "text/html;charset=UTF-8");
			//3.发送邮件Transport
			Transport.send(message);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
