package com.scuthnweb.action.actmodule;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.ActModuleImpl;
import com.scuthnweb.service.interf.ActModule;

public class CheckTakePartInUserInfoAction extends ActionSupport{
	
	private ActModule actModule;
	
	private int event_id, event_publisher;

	public String execute(){
	    
		this.setActModule(new ActModuleImpl());
	    
		ActionContext ctx = ActionContext.getContext();
		this.setEvent_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		
		//调用业务逻辑层组件
		List<Object> actList_userInfo = this.actModule.checkTakePartInUserInfo(event_id, event_publisher);
	    
		List<Customer> takePartInActList_customer = new ArrayList<Customer>();
	    List<Admin>    takePartInActList_admin    = new ArrayList<Admin>();
		
	    
	    //进行 Object 向下 Customer 转型
	    //若抛出 ClassCastException 异常
	    //则转为 Admin 类型
	    for(int i=0; i<actList_userInfo.size(); i++){
	       try{
	    	   takePartInActList_customer.add( (Customer)actList_userInfo.get(i) );
	       }catch( ClassCastException e){
	    	   takePartInActList_admin.add( (Admin)actList_userInfo.get(i) );
	      }
	    }
	    
	    //将得到的参与活动的普通用户与管理员信息分别放入 session 中
	    ctx.getSession().put("takePartInActList_customer", takePartInActList_customer);
	    ctx.getSession().put("takePartInActList_admin", takePartInActList_admin);
	    
	    return SUCCESS;
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
	public void setActModule(ActModule actModule) {
		this.actModule = actModule;
	}

}
