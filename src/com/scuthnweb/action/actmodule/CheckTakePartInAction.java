package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class CheckTakePartInAction extends ActionSupport{
	
	private ActModule actModule;
	
	private       int event_customer;


	public String execute(){
		
		this.actModule = new ActModuleImpl();
		
		ActionContext ctx = ActionContext.getContext();
		
		//获取管理员或普通用户的 id
		if( ctx.getSession().get("admin") !=null )
			  this.setEvent_customer( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		else  this.setEvent_customer( ((Admin)ctx.getSession().get("customer")).getAdmin_id() );
		
		//将获取的结果放入 session
		ctx.getSession().put("takePartInActList", this.actModule.checkTakePartIn(event_customer));
		return SUCCESS;
	}
	

	public int getEvent_customer() {
		return event_customer;
	}
	public void setEvent_customer(int event_customer) {
		this.event_customer = event_customer;
	}

}
