package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class SetNeedSuccAction extends ActionSupport{
	private NeedModule needModule;
	private int        need_id,need_publisher;

    public String execute(){
    	
		this.needModule = new NeedModuleImpl();
		
		//由session 中获取当前进行设置需求已解决的普通用户或管理员 id
		ActionContext ctx = ActionContext.getContext();
		if( ctx.getSession().get("admin") != null)  
				this.setNeed_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		else    this.setNeed_publisher( ((Customer)ctx.getSession().get("customer")).getId() ); 
		
		if( this.needModule.setNeedSucc( need_id, need_publisher ))
			  return SUCCESS;
		else  return ERROR;		
	}

	public int getNeed_id() {
		return need_id;
	}

	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}

	public int getNeed_publisher() {
		return need_publisher;
	}

	public void setNeed_publisher(int need_publisher) {
		this.need_publisher = need_publisher;
	}

}
