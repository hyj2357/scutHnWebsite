package com.scuthnweb.action.useradmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.UserAdminImpl;
import com.scuthnweb.service.interf.UserAdmin;

public class UserPasswordChange extends ActionSupport{
	
	private     UserAdmin userAdmin;
	
	private     int   customer_id;
	private  String   customer_password,customer_passwordM;
	
	public   String execute(){
		
    	this.userAdmin  = new UserAdminImpl();
    	
    	//获取 session 中的 customer_id
    	ActionContext ctx = ActionContext.getContext();   	
    	this.setCustomer_id( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
    	
    	//检测用户名与密码是否正确
    	if( this.userAdmin.userIDLogin(customer_id, null, customer_password) == null )  return ERROR;
    	
    	//调用业务逻辑层修改密码
    	if(!this.userAdmin.userPasswordChange(customer_id, customer_passwordM) )        return ERROR;        
    	return SUCCESS;		
	}
	
	public   void   validate(){
		
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
    public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
    
    
    public String getCustomer_password() {
		return customer_password;
	}
    public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
    }

	public String getCustomer_passwordM() {
		return customer_passwordM;
	}
	public void setCustomer_passwordM(String customer_passwordM) {
		this.customer_passwordM = customer_passwordM;
	}
	
}
