package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.impl.ResLinkModuleImpl;
import com.scuthnweb.service.interf.ResLinkModule;

public class Op_LinkAction extends ActionSupport{
	
	private ResLinkModule resLinkModule;
    
	private int share_link_id, setState, share_link_publisher;
	
	
    public String  execute(){
        
    	this.resLinkModule = new ResLinkModuleImpl();
    	
    	ActionContext ctx = ActionContext.getContext();
                
        //获取管理员id
        this.setShare_link_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
    	     
        if( this.resLinkModule.op_Link(share_link_id, setState, share_link_publisher) )
        	  return SUCCESS;
        else  return ERROR;
    }
	

	public int getShare_link_id() {
		return share_link_id;
	}
	public void setShare_link_id(int share_link_id) {
		this.share_link_id = share_link_id;
	}
	
	
	public int getSetState() {
		return setState;
	}	
	public void setSetState(int setState) {
		this.setState = setState;
	}
	
	
	public int getShare_link_publisher() {
		return share_link_publisher;
	}
	public void setShare_link_publisher(int share_link_publisher) {
		this.share_link_publisher = share_link_publisher;
	}
	
	

}
