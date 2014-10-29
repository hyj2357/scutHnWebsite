package com.scuthnweb.dao.interf;

import java.sql.SQLException;
import java.util.List;

import com.scuthnweb.domain.Customer;





public interface CustomerDao {
	
	/**
	 * Jun:
	 * @Param customer_name
	 * @param customer_password
	 * @return
	 */
	public    Customer findByNameAndPassword( String customer_name, String customer_password ) throws SQLException;
	
	/**
	 * Jun:
	 * @param customer_id
	 * @param customer_password
	 * @return
	 */
	public    Customer findByIdAndPassword(int customer_id, String customer_password );
	
	/**
	 * Jun：
	 * @param customer_name
	 * @param customer_password
	 * @param customer_sex
	 * @param customer_email
	 * @param customer_grade
	 * @param customer_major
	 * @param customer_phone
	 * @param customer_qq
	 * @param customer_room
	 * @return
	 * @throws SQLException
	 */
    public    Customer createCustomer( String customer_name,
    	                           String customer_password,
    	                           int    customer_sex,
    	                           String customer_email, 
    	                           String customer_grade,
    	                           String customer_major,
    	                           int    customer_phone,
    	                           int    customer_qq,
    	                           String customer_room) throws SQLException;
    
    
    
  /**
   * Jun:条件化更新用户信息
   * @param customer_id
   * @param customer_idM
   * @param customer_name
   * @param customer_password
   * @param customer_sex
   * @param customer_email
   * @param customer_grade
   * @param customer_major
   * @param customer_phone
   * @param customer_qq
   * @param customer_room
   * @param customer_state
   * @return
   */
    public    Customer updateCustomer( 
    		                       int    customer_id,
    		                       int    customer_idM,
    		                       String customer_name,
    	                           String customer_password,
    	                           int    customer_sex,
    	                           String customer_email, 
    	                           String customer_grade,
    	                           String customer_major,
    	                           int    customer_phone,
    	                           int    customer_qq,
    	                           String customer_room,
    	                           int    customer_state);
    
    
    /**
     * Jun：条件式查找用户信息
     * @param customer_id
     * @param customer_name
     * @param customer_password
     * @param customer_sex
     * @param customer_email
     * @param customer_grade
     * @param customer_major
     * @param customer_phone
     * @param customer_qq
     * @param customer_room
     * @param customer_state
     * @return
     */
    public  List<Customer> findCustomerM( int    customer_id,
                                   String customer_name,
                                   String customer_password,
                                   int    customer_sex,
                                   String customer_email, 
                                   String customer_grade,
                                   String customer_major,
                                   int    customer_phone,
                                   int    customer_qq,
                                   String customer_room,
                                   int    customer_state);
    
    
    /**
     * 
     * @param customer_email
     * @return
     */
    public    Customer   findCustomerByCustomerEmail( String customer_email );
    
    
    /**
     * 
     * @param customer_id
     * @return
     */
    public    Customer   findCustomerByCustomerID( int   customer_id);
}
