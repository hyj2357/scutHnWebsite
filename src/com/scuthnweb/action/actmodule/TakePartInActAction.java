package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class TakePartInActAction extends ActionSupport{
	
	private ActModule actModule;

	private int event_id, event_customer;

	
	public String execute(){
		
	   this.setActModule(new ActModuleImpl());	
	
	 //从session中获取当前要参与活动的 用户或 管理员 id
	 ActionContext ctx = ActionContext.getContext();
	 
	 if(ctx.getSession().get("customer")!=null)
 		   this.setEvent_customer( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
	 else  this.setEvent_customer( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
	 
	 if(this.actModule.takePartInAct(event_id, event_customer))
		   return SUCCESS;
	 else  return ERROR;
	}

	
	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}
	
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	public int getEvent_customer() {
		return event_customer;
	}
	public void setEvent_customer(int event_customer) {
		this.event_customer = event_customer;
	}
	
	
}
