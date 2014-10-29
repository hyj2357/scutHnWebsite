package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class CheckAllActAction extends ActionSupport{
	
	private ActModule actModule;

	public String execute(){
	   this.actModule = new ActModuleImpl();	
	   
	   ActionContext ctx  = ActionContext.getContext();
	   
       //调用业务逻辑层组件
	   //并将结果放入session中
	   ctx.getSession().put("allActList",  this.actModule.checkAllAct( (ctx.getSession().get("admin") != null) ));	  
	   return SUCCESS;
	}
	
}
