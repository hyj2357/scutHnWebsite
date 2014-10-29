package com.scuthnweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.scuthnweb.dao.impl.CustomerDaoImpl;
import com.scuthnweb.dao.impl.MessageDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_messageDaoImpl;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Pub_rec_messageDao;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.AdminUser;

public class AdminUserImpl implements AdminUser{

	private CustomerDao        customerDao;
	private Pub_rec_messageDao pub_rec_messageDao;
	private MessageDao         messageDao;
	
	

	@Override
	public List<Customer> checkRegInfo() {
		
		this.customerDao = new CustomerDaoImpl();
		
		//调用 Dao 层方法
		List<Customer> regCustomerList = this.customerDao.findCustomerM(-1, null, null, -1, null, null, null, -1, -1, null, 1);
		
		//如果查询结果为空
		//则返回 一个空 List
		return  (regCustomerList == null) ? ( new ArrayList<Customer>() ) : regCustomerList;
	}

	
	@Override
	public List<Customer> checkUserInfo(int    customer_id,
                                        String customer_name, 
			                            int    customer_sex,
			                            String customer_grade, 
			                            String customer_major, 
			                            int    customer_phone,
			                            int    customer_qq, 
			                            String customer_email, 
			                            String customer_room) {
		
		this.customerDao = new CustomerDaoImpl();
		
		//调用Dao层方法
		List<Customer> userInfoList = this.customerDao.findCustomerM(customer_id, customer_name, null, customer_sex, customer_email, customer_grade, customer_major, customer_phone, customer_qq, customer_room, -1);
		
		//如果查询结果为空
		//则返回 一个空 List
		return ( userInfoList == null) ? ( new ArrayList<Customer>()) : userInfoList;
	}

	
	@Override
	public boolean logoutUserID(int customer_id) {
		
		this.customerDao = new CustomerDaoImpl();
		
		//限制权限？？？这是注销！！！
		//限制用户所有权限
		if( this.customerDao.updateCustomer(customer_id, -1, null, null, -1, null, null, null, -1, -1, null,1)==null)
			  return false;		
		else  return true;
	}

	
//	@Override
	public boolean modifyUserInfo(int    admin_id, 
			                      int    customer_id,
			                      String customer_name, 
			                      String customer_password,
			                      int    customer_sex,
			                      String customer_grade, 
			                      String customer_major, 
			                      int    customer_phone,
			                      int    customer_qq, 
			                      String customer_email, 
			                      String customer_room) {
		
		this.customerDao        = new CustomerDaoImpl();
		this.messageDao         = new MessageDaoImpl();
		this.pub_rec_messageDao = new Pub_rec_messageDaoImpl();
		
		//修改失败
		//返回 false
		//修改成功
		//将消息发送至被修改信息的普通用户
		//并返回 true
		if( this.customerDao.updateCustomer(customer_id, -1, customer_name, customer_password, customer_sex, customer_email, customer_grade, customer_major, customer_phone, customer_qq, customer_room, -1)==null)
		      return false;
		else  {
			   this.messageDao.createMessage(message_id, "管理员 "+"(id:" + admin_id + ")"+"修改了您的个人信息。");
			   this.pub_rec_messageDao.createPub_rec_Message(customer_id, admin_id, message_id);
			   return true;
		}
	}
	
}