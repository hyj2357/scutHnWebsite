package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Customer;

public interface AdminUser {
	
	/**
	 * Jun:审核用户注册信息
	 * @validate no
	 * @interrupt yes  
	 * @return
	 */
	public List<Customer> checkRegInfo();
    
	/**
	 * Jun: 查看用户信息
	 * @validate yes
	 * @interrupt yes
	 * @param customer_id
	 * @param customer_name
	 * @param customer_sex
	 * @param customer_grade
	 * @param customer_major
	 * @param customer_phone
	 * @param customer_qq
	 * @param customer_email
	 * @param customer_room
	 * @return
	 */
	public List<Customer> checkUserInfo( int    customer_id,
			                             String customer_name,
                                         int    customer_sex, 
                                         String customer_grade, 
                                         String customer_major,
                                         int    customer_phone, 
                                         int    customer_qq, 
                                         String customer_email,
                                         String customer_room);


	/**
	 * Jun: 注销用户账号
	 * @validate no
	 * @interrupt yes
	 * @param Customer_id
	 * @return
	 */
    public  boolean logoutUserID( int Customer_id);


    /**
     * Jun: 修改用户信息
     * @validate yes
     * @interrupt yes
     * @param admin_id
     * @param customer_id
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
     * @return
     */
    public  boolean modifyUserInfo( int    admin_id,
			                        int    customer_id,
			                        String customer_name,
                                    String customer_password, 
                                    int    customer_sex, 
                                    String customer_grade, 
                                    String customer_major,
                                    int    customer_phone, 
                                    int    customer_qq, 
                                    String customer_email,
                                    String customer_room);
}
