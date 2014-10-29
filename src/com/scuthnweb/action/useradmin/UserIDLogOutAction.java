package com.scuthnweb.action.useradmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserIDLogOutAction extends ActionSupport{
	
	public String execute(){
		
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().remove("customer_id");
		ctx.getSession().remove("customer_name");
		return SUCCESS;		
	}

}
