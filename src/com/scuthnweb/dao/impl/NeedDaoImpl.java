package com.scuthnweb.dao.impl;

import java.util.List;

import com.scuthnweb.dao.interf.NeedDao;
import com.scuthnweb.domain.Need;

public class NeedDaoImpl implements NeedDao{

	@Override
	public Need createNeed(String need_name, String need_content,
			int need_publisher) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Need> findByNeed_ID(int need_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Need> findByNeed_publisher(int need_publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Need updateNeed(int need_id, int need_idM, String need_name, String need_content, int need_state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Need> findNeedM(int need_id, String need_name,
			String need_content, int need_publisher, int need_state) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteNeed(int need_id, int need_state) {
		// TODO Auto-generated method stub
		return false;
	}

}
