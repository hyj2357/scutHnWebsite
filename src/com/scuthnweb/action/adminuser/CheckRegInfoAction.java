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
		
		//调用业务逻辑层组件
		List<Customer> userInfoList = this.adminUser.checkRegInfo();
		
		//将结果 userInfoList 放入 session 中
		ActionContext ctx = ActionContext.getContext();
	    ctx.getSession().put("userInfoList", userInfoList);
	    
	    return SUCCESS;
	}
	
}
