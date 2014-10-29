package com.scuthnweb.action.needmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class AcceptNeedAction extends ActionSupport{
	
	private NeedModule  needModule;
	
	private int need_id, need_reciever;

	
	public  String execute(){
	    
	    this.needModule =  new NeedModuleImpl();
	    
	    ActionContext ctx = ActionContext.getContext();
	    
	    //获取接受需求的普通用户或管理员 id
	    if( ctx.getSession().get("customer") != null)
	          this.setNeed_reciever( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
	    else  this.setNeed_reciever( ((Admin)ctx.getSession().get("customer")).getAdmin_id() );
	    
	    //调用业务逻辑层组件
	    if( this.needModule.acceptNeed( need_id, need_reciever ))
	    	  return SUCCESS;
	    else  return ERROR;
	    
	}
	
	
	public void setNeedModule(NeedModule needModule) {
		this.needModule = needModule;
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