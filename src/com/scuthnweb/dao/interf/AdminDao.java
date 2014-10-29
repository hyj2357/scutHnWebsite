package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Admin;

public interface AdminDao {
	/**
	 * Jun:通过管理员名与密码查找管理员
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin findByNameAndPassword( String admin_name, String admin_password);
	
	
	/**
	 * Jun:创建管理员
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin createAdmin( String admin_name, String admin_password );
	
	
	/**
	 * Jun:条件式更新管理员信息
	 * @param admin_id
	 * @param admin_idM
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin upDateAdmin( int admin_id, int admin_idM, String admin_name, String admin_password );
	
	 /**
     * Jun:条件式查找管理员信息
     * @param admin_id
     * @param admin_name
     * @param admin_password
     * @return
     */
	public List<Admin> findAdminM( int admin_id, String admin_name, String admin_password);

	/**
	 * Jun:通过管理员id查找管理员
	 * @param admin_id
	 * @return
	 */
	public Admin findAdminByAdminId( int admin_id );
	
	
   
}
