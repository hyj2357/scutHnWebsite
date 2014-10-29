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
	   
       //����ҵ���߼������
	   //�����������session��
	   ctx.getSession().put("allActList",  this.actModule.checkAllAct( (ctx.getSession().get("admin") != null) ));	  
	   return SUCCESS;
	}
	
}
