package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Share_link;

public interface ResLinkModule {
	
	/**
	 * Jun:删除链接
	 * @validate  no
	 * @interrupt yes
	 * @param share_link_id
	 * @return
	 */
	public boolean delLink( int share_link_id , int share_link_publisher);
	
	
	/**
	 * Jun：管理员审核链接
	 * @validate  no
	 * @interrupt yes
	 * @param share_link_id
	 * @param setState
	 * @param share_link_publisher
	 * @return
	 */
	public boolean op_Link( int share_link_id, int setState, int share_link_publisher);
	
	
	/**
	 * Jun：更新链接
	 * @validate  yes
	 * @interrupt yes
	 * @param share_link_id
	 * @param share_link_publisher
	 * @param share_link_name
	 * @param share_link_Content
	 * @return
	 */
	public boolean updateLink( int    share_link_id,
			                   int    share_link_publisher,
			                   String share_link_name,
			                   String share_link_Content);
	
	
	/**
	 * Jun:上传链接
	 * @validate  yes
	 * @interrupt yes
	 * @param share_link_publisher
	 * @param share_link_name
	 * @param share_link_Content
	 * @return
	 */
	public boolean uploadLink( int    share_link_publisher,			
			                   String share_link_name,
			                   String share_link_Content);

	
	/**
	 * Jun：查看所有资源链接
	 * @validate  no
	 * @interrupt no 
	 * @param isAdmin
	 * @return
	 */
	public List<Share_link> checkAllResLink( boolean isAdmin);
	
	
	/**
	 * Jun:查看本人上传的链接
	 * @validate  no
	 * @interrupt yes 
	 * @param share_link_publisher
	 * @return
	 */
	public List<Share_link> checkUploadLink( int share_link_publisher );
	
	
	/**
	 * Jun:查看待审核链接
	 * @validate  no
	 * @interrupt yes
	 * @return
	 */
	public List<Share_link> checkVerifyLink( );
}
