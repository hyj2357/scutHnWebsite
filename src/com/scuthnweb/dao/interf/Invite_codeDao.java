package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Invite_code;

public interface Invite_codeDao {
	/**
	 * 
	 * @param Invite_code_content
	 * @return
	 */
	public  Invite_code createInvite_code( String Invite_code_content);
	
	
	/**
	 * 
	 * @param Invite_code_content
	 * @return
	 */
	public  Invite_code findByInvite_code( String Invite_code_content);
	
	
	
	/**
	 * Jun:条件式更新邀请码表
	 * @param Invite_code_content
	 * @param Invite_code_contentM
	 * @return
	 */
	public  Invite_code updateInvite_code( String Invite_code_content, String Invite_code_contentM);
	
	
	
	/**
	 * Jun:条件式查询邀请码表
	 * @param Invite_code_content
	 * @return
	 */	
	public  List<Invite_code> findInvite_codeM( String Invite_code_content);

}
