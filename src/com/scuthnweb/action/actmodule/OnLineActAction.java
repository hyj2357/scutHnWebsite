package com.scuthnweb.action.actmodule;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class OnLineActAction extends ActionSupport{
	private  ActModule actModule;
	
	private  int    event_id, event_maxPeople, event_publisher;
    private  String event_name, event_intro;
    private  Date   event_time, event_endtime;
    
    
	public String execute(){
		
		this.actModule = new ActModuleImpl();
	
		//获取上线活动的管理员id
		ActionContext ctx = ActionContext.getContext();
		this.setEvent_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );		
		
		//调用业务逻辑层组件
	    if(this.actModule.onLineAct(event_id, event_name, event_intro, event_time, event_endtime, event_maxPeople, event_publisher, 0))
	    	  return SUCCESS;
	    else  return ERROR;		
	}
    
d
项目问题7
	public void validate(){
		
	}
    
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getEvent_maxPeople() {
		return event_maxPeople;
	}
	public void setEvent_maxPeople(int event_maxPeople) {
		this.event_maxPeople = event_maxPeople;
	}
	public int getEvent_publisher() {
		return event_publisher;
	}
	public void setEvent_publisher(int event_publisher) {
		this.event_publisher = event_publisher;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_intro() {
		return event_intro;
	}
	public void setEvent_intro(String event_intro) {
		this.event_intro = event_intro;
	}
	public Date getEvent_time() {
		return event_time;
	}
	public void setEvent_time(Date event_time) {
		this.event_time = event_time;
	}
	public Date getEvent_endtime() {
		return event_endtime;
	}
	public void setEvent_endtime(Date event_endtime) {
		this.event_endtime = event_endtime;
	}

}