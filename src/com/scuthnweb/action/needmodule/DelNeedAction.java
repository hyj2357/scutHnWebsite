package com.scuthnweb.action.needmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class DelNeedAction extends ActionSupport{
	
	private NeedModule needModule; 
	private int need_id, need_publisher;
	 

	public  String execute(){
	     
		 this.needModule = new NeedModuleImpl(); 
	     
		 ActionContext ctx = ActionContext.getContext();
		 
		 //如果当前是管理员操作
		 //获取管理员id
		 //否则获取当前进行操作的用户 id
		 if( ctx.getSession().get("admin") != null) this.setNeed_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		 else this.setNeed_publisher( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
		 
		 //调用业务逻辑层组件
	     if( this.needModule.delNeed(need_id, need_publisher))
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
