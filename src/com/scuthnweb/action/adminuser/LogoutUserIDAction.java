package com.scuthnweb.action.adminuser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.AdminUserImpl;
import com.scuthnweb.service.interf.AdminUser;

public class LogoutUserIDAction extends ActionSupport{

	private AdminUser adminUser;

    private int customer_id;
    
    
    public String execute(){
    	
    	this.adminUser = new AdminUserImpl();
    	
    	ActionContext ctx = ActionContext.getContext();
    	
    	//如果当前是用户本人想要注销账号
    	//则获取用户本人的 id
    	if( ctx.getSession().get("customer") != null) 
    		  this.setCustomer_id( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
    	
    	if( this.adminUser.logoutUserID(customer_id))
    		  return SUCCESS;
    	else  return ERROR;
    }
    
    
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	} 
    
}