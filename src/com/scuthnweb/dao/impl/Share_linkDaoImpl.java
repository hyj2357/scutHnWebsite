package com.scuthnweb.dao.impl;

import java.util.List;

import com.scuthnweb.dao.interf.Share_linkDao;
import com.scuthnweb.domain.Share_link;

public class Share_linkDaoImpl implements Share_linkDao{

	@Override
	public Share_link createShare_link(String share_link_name,
			String share_link_content, int share_link_publisher) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Share_link> findByShare_link_id(int share_link_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Share_link updateShare_link(int share_link_id, int share_link_idM,
			String share_link_name, String share_link_content,
			int share_link_state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Share_link> findShare_linkM(int share_link_id, String share_link_name, String share_link_content,int share_link_publisher, int share_link_state) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean deleteShare_link(int share_link_id, int share_link_publisher) {
		// TODO Auto-generated method stub
		return false;
	}

}
