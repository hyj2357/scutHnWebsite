package com.scuthnweb.service.interf;

import java.sql.SQLException;

import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;



public interface UserAdmin {
	
   /**
    * Jun:   用户找回密码
    * @Param customer_name
    * @param customer_email
    * @return boolean
    */
	public boolean   userFindPassWord( String customer_name, String customer_email );
	
	
	/**
	 * Jun:   用户登录
	 * @Param customer_name
	 * @param customer_password
	 * @return Customer
	 */
	public BaseCustomer  userIDLogin(int customer_id, String customer_name, String customer_password);	
	
	public void      userIDLogOut();	
	
	
	/**
	 * Jun:用户注册
	 * @param customer_name
	 * @param customer_password
	 * @param invite_code_Content
	 * @param customer_sex
	 * @param customer_grade
	 * @param customer_major
	 * @param customer_phone
	 * @param customer_qq
	 * @param customer_email
	 * @param customer_room
	 * @return Customer
	 * @throws SQLException
	 */
	public BaseCustomer  userIDResgist( String	 customer_name,
	                                String   customer_password,
	                                String   invite_code_Content,
	                                   int   customer_sex,
	                                String   customer_grade,
	                                String   customer_major,
	                                   int   customer_phone,
	                                   int   customer_qq,
	                                String   customer_email,
	                                String   customer_room);	
	
	
	/**
	 * Jun: 用户查看个人信息
	 * @param  customer_id
	 * @return Customer
	 */
	public Customer userInfoCheck( int customer_id);	
	
	
	/**
	 * Jun: 用户修改个人信息
	 * @param customer_id
	 * @param customer_sex
	 * @param customer_grade
	 * @param customer_major
	 * @param customer_phone
	 * @param customer_qq
	 * @param customer_email
	 * @param customer_room
	 * @return boolean
	 */
	public boolean  userInfoModify( int    customer_id,		
	                                int	   customer_sex,
	                                String customer_grade,
	                                String customer_major,
	                                int    customer_phone,
	                                int    customer_qq,
	                                String customer_email,
	                                String customer_room);
	 
	
	/**
	 * Jun: 用户修改密码
	 * @param  customer_id
	 * @param  customer_password
	 * @return boolean
	 */
	public boolean userPasswordChange( int customer_id, String customer_password );

	
}
