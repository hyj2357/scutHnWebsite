package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Customer;

public interface AdminUser {
	
	/**
	 * Jun:����û�ע����Ϣ
	 * @validate no
	 * @interrupt yes  
	 * @return
	 */
	public List<Customer> checkRegInfo();
    
	/**
	 * Jun: �鿴�û���Ϣ
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
	 * Jun: ע���û��˺�
	 * @validate no
	 * @interrupt yes
	 * @param Customer_id
	 * @return
	 */
    public  boolean logoutUserID( int Customer_id);


    /**
     * Jun: �޸��û���Ϣ
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
