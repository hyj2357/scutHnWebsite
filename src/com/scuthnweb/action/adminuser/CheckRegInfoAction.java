package com.scuthnweb.action.adminuser;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.AdminUserImpl;
import com.scuthnweb.service.interf.AdminUser;

public class CheckRegInfoAction extends ActionSupport{
	
	private AdminUser adminUser;
    
	public String execute(){
		
		this.adminUser = new AdminUserImpl();
		
		//����ҵ���߼������
		List<Customer> userInfoList = this.adminUser.checkRegInfo();
		
		//����� userInfoList ���� session ��
		ActionContext ctx = ActionContext.getContext();
	    ctx.getSession().put("userInfoList", userInfoList);
	    
	    return SUCCESS;
	}
	
}
