package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Need;

public interface NeedModule {
	/**
	 * Jun: 接受需求
	 * @validate  no
	 * @interrupt yes
	 * @param need_id
	 * @param need_reciever
	 * @return
	 */
	public boolean acceptNeed( int need_id, int need_reciever );
	
	
	/**
	 * Jun:撤销接受需求
	 * @validate  no
	 * @interrupt yes
	 * @param need_id
	 * @param need_reciever
	 * @return
	 */
	public boolean cancelAcNeed( int need_id, int need_reciever );
	
	
	/**
	 * Jun:查看所有需求信息
	 * @validate  no
	 * @interrupt no
	 * @param isAdmin 
	 * @return
	 */
	public List<Need> checkAllNeed(boolean isAdmin);
	
	
	/**
	 * Jun:用户查看自己发布的所有需求信息
	 * @validate  no
	 * @interrupt yes 
	 * @param need_publisher
	 * @return
	 */
	public List<Need> checkPostNeed( int need_publisher );
	
	
	/**
	 * Jun:用户查看自己接受的需求信息
	 * @validate  no
	 * @interrupt yes 
	 * @param need_reciever
	 * @return
	 */
	public List<Need> checkAcNeed( int need_reciever );
	
	
	/**
	 * Jun:用户查看接受自己发布的需求的相关用户信息
	 * @validate  no
	 * @interrupt yes 
	 * @param need_id
	 * @param need_publisher
	 * @return
	 */
	public List<Object> checkAcNeedUserInfo( int need_id, int need_publisher);
	
	
	/**
	 * Jun: 删除需求
	 * @validate  no
	 * @interrupt yes
	 * @param need_id
	 * @return
	 */
	public boolean delNeed(  int need_id , int need_publisher);
	
	
	/**
	 * Jun: 发布需求
	 * @validate yes
	 * @interrupt yes
	 * @param need_name
	 * @param need_content
	 * @param need_publisher
	 * @return
	 */
	public boolean postNeed( String need_name, String need_content, int need_publisher );
	
	
	/**
	 * Jun: 修改已发布的需求
	 * @validate yes
	 * @interrupt yes
	 * @param need_id
	 * @param need_name
	 * @param need_content
	 * @return
	 */
	public boolean modifyNeed( int need_id, String need_name, String need_content);
	
	
	/**
	 * Jun: 设置需求为已解决
	 * @validate yes
	 * @interrupt yes
	 * @param need_id
	 * @return
	 */
	public boolean setNeedSucc( int need_id ,int need_publisher);
}
