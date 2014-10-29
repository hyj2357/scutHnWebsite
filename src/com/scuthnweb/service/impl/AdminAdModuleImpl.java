package com.scuthnweb.service.impl;

import java.util.List;

import com.scuthnweb.dao.impl.AdminDaoImpl;
import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.interf.AdminAdModule;

public class AdminAdModuleImpl implements AdminAdModule{

	private AdminDao adminDao;


	@Override
	public Admin adminLogin(int admin_id, String admin_password) {
		
		this.adminDao = new AdminDaoImpl();
		
		//调用Dao层方法
		List<Admin> ad = this.adminDao.findAdminM(admin_id, null, admin_password);
		
		return ( ad == null )? null : ((Admin)ad.get(0)) ;
	}


	
	@Override
	public boolean modifyPassword(int admin_id, String admin_password, String admin_passwordM) {
		
		this.adminDao = new AdminDaoImpl();
		
		//检测原密码是否正确
		if( this.adminDao.findAdminM(admin_id, null, admin_password ) == null) return false;
		
		//调用Dao层方法
		//成功修改返回 true
		//否则返回 false
		return ( this.adminDao.upDateAdmin(admin_id, -1, null, admin_passwordM) != null );
	}


	@Override
	public Admin setName(int admin_id, String admin_nameM) {
		
		this.adminDao = new AdminDaoImpl();
		
		//调用Dao层方法更新管理员名称
		return this.adminDao.upDateAdmin( admin_id, -1, admin_nameM, null);
	}


	@Override
	public Admin checkAdminInfo(int admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
