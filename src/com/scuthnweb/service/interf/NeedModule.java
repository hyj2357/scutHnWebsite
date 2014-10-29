package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Need;

public interface NeedModule {
	/**
	 * Jun: ��������
	 * @validate  no
	 * @interrupt yes
	 * @param need_id
	 * @param need_reciever
	 * @return
	 */
	public boolean acceptNeed( int need_id, int need_reciever );
	
	
	/**
	 * Jun:������������
	 * @validate  no
	 * @interrupt yes
	 * @param need_id
	 * @param need_reciever
	 * @return
	 */
	public boolean cancelAcNeed( int need_id, int need_reciever );
	
	
	/**
	 * Jun:�鿴����������Ϣ
	 * @validate  no
	 * @interrupt no
	 * @param isAdmin 
	 * @return
	 */
	public List<Need> checkAllNeed(boolean isAdmin);
	
	
	/**
	 * Jun:�û��鿴�Լ�����������������Ϣ
	 * @validate  no
	 * @interrupt yes 
	 * @param need_publisher
	 * @return
	 */
	public List<Need> checkPostNeed( int need_publisher );
	
	
	/**
	 * Jun:�û��鿴�Լ����ܵ�������Ϣ
	 * @validate  no
	 * @interrupt yes 
	 * @param need_reciever
	 * @return
	 */
	public List<Need> checkAcNeed( int need_reciever );
	
	
	/**
	 * Jun:�û��鿴�����Լ����������������û���Ϣ
	 * @validate  no
	 * @interrupt yes 
	 * @param need_id
	 * @param need_publisher
	 * @return
	 */
	public List<Object> checkAcNeedUserInfo( int need_id, int need_publisher);
	
	
	/**
	 * Jun: ɾ������
	 * @validate  no
	 * @interrupt yes
	 * @param need_id
	 * @return
	 */
	public boolean delNeed(  int need_id , int need_publisher);
	
	
	/**
	 * Jun: ��������
	 * @validate yes
	 * @interrupt yes
	 * @param need_name
	 * @param need_content
	 * @param need_publisher
	 * @return
	 */
	public boolean postNeed( String need_name, String need_content, int need_publisher );
	
	
	/**
	 * Jun: �޸��ѷ���������
	 * @validate yes
	 * @interrupt yes
	 * @param need_id
	 * @param need_name
	 * @param need_content
	 * @return
	 */
	public boolean modifyNeed( int need_id, String need_name, String need_content);
	
	
	/**
	 * Jun: ��������Ϊ�ѽ��
	 * @validate yes
	 * @interrupt yes
	 * @param need_id
	 * @return
	 */
	public boolean setNeedSucc( int need_id ,int need_publisher);
}
