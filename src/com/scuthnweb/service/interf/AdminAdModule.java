package com.scuthnweb.service.interf;

import com.scuthnweb.domain.Admin;

public interface AdminAdModule {
	
	/**
	 * Jun:����Ա��¼
	 * @validate yes
	 * @interrupt no
	 * @param admin_id
	 * @param admin_password
	 * @return
	 */
	public Admin adminLogin( int admin_id, String admin_password);

	/**
	 * Jun:����Ա�鿴������Ϣ
	 * @validate no
	 * @interrupt yes
	 * @param admin_id
	 * @return
	 */
	public Admin checkAdminInfo( int admin_id );
	
	
	/**
	 * Jun:����Ա�޸�����
	 * @validate yes
	 * @interrupt yes
	 * @param admin_id
	 * @param admin_password
	 * @param admin_passwordM
	 * @return
	 */
	public boolean modifyPassword(int admin_id, String admin_password, String admin_passwordM);
	
	
	/**
	 * Jun:����Ա�޸�����
	 * @validate yes
	 * @interrupt no
	 * @param admin_id
	 * @param admin_nameM
	 * @return
	 */
	public Admin setName( int admin_id, String admin_nameM);
}
