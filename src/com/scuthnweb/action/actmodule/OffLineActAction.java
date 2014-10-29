package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class OffLineActAction extends ActionSupport{
	
     private ActModule actModule;
     
     private int event_id, event_publisher;

     public String execute(){
    	 
    	 this.actModule = new ActModuleImpl();
    	 
    	 //获取管理员 id
    	 ActionContext ctx = ActionContext.getContext();
    	 this.setEvent_publisher(((Admin)ctx.getSession().get("admin")).getAdmin_id());
    	 
    	 //调用业务逻辑层组件
    	 if(this.actModule.offLineAct(event_id, event_publisher))
    		  return SUCCESS;
    	 else return ERROR;
    	 
     }

     
     
	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getEvent_publisher() {
		return event_publisher;
	}
	public void setEvent_publisher(int event_publisher) {
		this.event_publisher = event_publisher;
	}
          
}