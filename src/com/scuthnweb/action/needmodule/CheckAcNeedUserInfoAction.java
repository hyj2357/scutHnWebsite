package com.scuthnweb.action.needmodule;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class CheckAcNeedUserInfoAction extends ActionSupport{
      
	  private  NeedModule needModule;
      
      private  int need_id, need_publisher;
      
      public  String execute(){
    	  
    	this.needModule = new NeedModuleImpl();  
      
    	//由session 中获取当前进行查看接受需求表操作的普通用户或管理员 id
    	ActionContext ctx = ActionContext.getContext();
    	if( ctx.getSession().get("admin") != null)  
    			this.setNeed_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
    	else    this.setNeed_publisher( ((Customer)ctx.getSession().get("customer")).getId() ); 
    	
    	List<Customer> acNeedCustomerList  = new ArrayList<Customer>();
    	List<Admin>    acNeedAdminList     = new ArrayList<Admin>();
    	
    	//调用业务逻辑层组件
    	List<Object>   acNeedUserList = this.needModule.checkAcNeedUserInfo(need_id, need_publisher);
    	
    	//进行 Object 向下 Customer 转型
	    //若抛出 ClassCastException 异常
	    //则转为 Admin 类型
	    for(int i=0; i<acNeedUserList.size(); i++){
	       try{
	    	   acNeedCustomerList.add((Customer)acNeedUserList.get(i));
	       }catch( ClassCastException e){
	    	   acNeedAdminList.add((Admin)acNeedUserList.get(i));
	      }
	    }
	    
	    //将得到的参与活动的普通用户与管理员信息分别放入 session 中
	    ctx.getSession().put("acNeedCustomerList", acNeedCustomerList);
	    ctx.getSession().put("acNeedAdminList", acNeedAdminList);
        
	    return SUCCESS;
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
