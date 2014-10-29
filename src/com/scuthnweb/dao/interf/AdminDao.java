package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Admin;

public interface AdminDao {
	/**
	 * Jun:ͨ������Ա����������ҹ���Ա
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin findByNameAndPassword( String admin_name, String admin_password);
	
	
	/**
	 * Jun:��������Ա
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin createAdmin( String admin_name, String admin_password );
	
	
	/**
	 * Jun:����ʽ���¹���Ա��Ϣ
	 * @param admin_id
	 * @param admin_idM
	 * @param admin_name
	 * @param admin_password
	 * @return
	 */
	public Admin upDateAdmin( int admin_id, int admin_idM, String admin_name, String admin_password );
	
	 /**
     * Jun:����ʽ���ҹ���Ա��Ϣ
     * @param admin_id
     * @param admin_name
     * @param admin_password
     * @return
     */
	public List<Admin> findAdminM( int admin_id, String admin_name, String admin_password);

	/**
	 * Jun:ͨ������Աid���ҹ���Ա
	 * @param admin_id
	 * @return
	 */
	public Admin findAdminByAdminId( int admin_id );
	
	
   
}
