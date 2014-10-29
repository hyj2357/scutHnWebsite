package com.scuthnweb.dao.impl;

import java.util.List;

import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.domain.Admin;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin findByNameAndPassword(String admin_name, String admin_password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin createAdmin(String admin_name, String admin_password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Admin findAdminByAdminId(int admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin upDateAdmin(int admin_id, int admin_idM, String admin_name,
			String admin_password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> findAdminM(int admin_id, String admin_name,
			String admin_password) {
		// TODO Auto-generated method stub
		return null;
	}

}
