package com.scuthnweb.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import com.scuthnweb.dao.impl.CustomerDaoImpl;
import com.scuthnweb.dao.impl.MessageDaoImpl;
import com.scuthnweb.dao.impl.Pub_rec_messageDaoImpl;
import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.dao.interf.Pub_rec_messageDao;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.interf.UserAdmin;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;


public class UserAdminImpl implements UserAdmin{
	
	private CustomerDao          customerDao;
	private Pub_rec_messageDao   pub_rec_messageDao;
	private MessageDao           messageDao;
	
d	
项目问题1
	/**
	 * warning: To be continue...
	 */
	public boolean userFindPassWord( String customer_name, String customer_email) {
	
	    this.customerDao = new CustomerDaoImpl();
		
		//customer set the message to the admin 
		//to find the password 
		this.messageDao.createMessage(message_id, "用户 \""+ customer_name + "\"请求找回密码" + "\r\n" + "邮箱：" + customer_email);
		this.pub_rec_messageDao.createPub_rec_Message(  message_receiver, 
				                                        this.customerDao.findCustomerM(-1, null, null, -1, customer_email, null, null, -1, -1, null, -1), 				                                        
				                                        message_id);
	}

	
	
	@Override
	public BaseCustomer userIDLogin( int customer_id, String customer_name, String customer_password){
		
		// user login
		// 调用 Dao 层相关方法
		List<Customer> cs = this.customerDao.findCustomerM(customer_id, null, customer_password, -1, null, null, null, -1, -1, null, -1);
		
		if( cs == null) return null;
		else            return ((BaseCustomer)cs.get(0));
		
	}

	
	
	@Override
	public void userIDLogOut() {  }
	
	

	@Override
	public BaseCustomer userIDResgist( String customer_name,
			                       String customer_password, 
			                       String invite_code_Content,
			                       int    customer_sex, 
			                       String customer_grade, 
			                       String customer_major,
			                       int    customer_phone, 
			                       int    customer_qq, 
			                       String customer_email,
			                       String customer_room){
				
		// user register ID		
		Customer cs = this.customerDao.createCustomer(customer_name, 
				                               customer_password, 
				                               customer_sex, 
				                               customer_email, 
				                               customer_grade, 
				                               customer_major, 
				                               customer_phone, 
				                               customer_qq, 
				                               customer_room) ;
		
		//返回 用户注册成功后的信息 Customer
		//如果注册失败，返回的则是   null
		if(cs==null) return  null;
		else         return (BaseCustomer)cs;
	}

	
	
	@Override
	public Customer userInfoCheck(int customer_id) {
		
		// search for the user's info 
		// return info		
		List<Customer> cs = this.customerDao.findCustomerM(customer_id, null, null, -1, null, null, null, -1, -1, null, -1);
	
		if( cs== null) return null;
		else           return cs.get(0);
	}

 
	public boolean userInfoModify( int    customer_id,
			                       int    customer_sex, 
			                       String customer_grade,
			                       String customer_major, 
			                       int    customer_phone, 
			                       int    customer_qq,
			                       String customer_email, 
			                       String customer_room) {
		
		
		Customer cs = this.customerDao.updateCustomer(customer_id, -1, null, null, 
				                                      customer_sex, customer_email, customer_grade, 
				                                      customer_major, customer_phone, customer_qq, 
				                                      customer_room,-1 );
		
		return  (cs==null)?false:true;
	}

	
	
	@Override
	public boolean userPasswordChange( int customer_id, String customer_password) {
		
		//调用Dao层方法
		Customer cs = this.customerDao.findByIdAndPassword(customer_id, customer_password);
		
		return  (cs==null)?false:true;
	}
  
}
