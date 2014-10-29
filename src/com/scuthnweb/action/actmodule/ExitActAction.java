package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class ExitActAction extends ActionSupport{
	
	private ActModule actModule;

	private int event_id, event_customer;
	
	
	public String execute(){
		
	    this.actModule = new ActModuleImpl();	
	
	  //从session中获取当前要退出活动的 用户或 管理员 id
	  ActionContext ctx = ActionContext.getContext();
	  if(ctx.getSession().get("customer")!=null)
	  		this.setEvent_customer( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
	  else  this.setEvent_customer( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
	    
	  //调用业务逻辑层组件
	  if(this.actModule.exitAct(event_id, event_customer))
	    	return SUCCESS;
	  else  return ERROR;
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
