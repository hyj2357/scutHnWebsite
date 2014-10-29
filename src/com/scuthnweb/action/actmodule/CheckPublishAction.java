package com.scuthnweb.action.actmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class CheckPublishAction extends ActionSupport{
	private  ActModule actModule;
	
	private  int       event_publisher;

	
	public String execute(){
		
		this.actModule = new ActModuleImpl();
		
		//��ȡ����Աid
		ActionContext ctx = ActionContext.getContext();
		this.setEvent_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id());
		
		//����ҵ���߼������
		ctx.getSession().put("publishActList", this.actModule.checkPublish(event_publisher));
		
		return SUCCESS;		
	}

	public int getEvent_publisher() {
		return event_publisher;
	}
	public void setEvent_publisher(int event_publisher) {
		this.event_publisher = event_publisher;
	}

}
