package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class CancelNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	
	private int need_id, need_reciever;

	
	public String execute(){
		
		this.needModule = new NeedModuleImpl();
		
		//由session 中获取当前进行撤销接受需求操作的普通用户或管理员 id
		ActionContext ctx = ActionContext.getContext();
		if( ctx.getSession().get("admin") != null)  
			    this.setNeed_reciever( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		else    this.setNeed_reciever( ((Customer)ctx.getSession().get("customer")).getId() );               
		
		//用用业务逻辑层组件
	    if( this.needModule.cancelAcNeed(need_id, need_reciever)) 
	    	  return SUCCESS;
	    else  return ERROR;
	}
	

	
	public int getNeed_id() {
		return need_id;
	}
	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}

	public int getNeed_reciever() {
		return need_reciever;
	}
	public void setNeed_reciever(int need_reciever) {
		this.need_reciever = need_reciever;
	}
	
	

}
