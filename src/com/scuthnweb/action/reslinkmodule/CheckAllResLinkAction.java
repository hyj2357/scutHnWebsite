package com.scuthnweb.action.reslinkmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.impl.ResLinkModuleImpl;
import com.scuthnweb.service.interf.ResLinkModule;

public class CheckAllResLinkAction extends ActionSupport {
	
	private ResLinkModule resLinkModule;
	
	public String execute(){
		
		this.resLinkModule = new ResLinkModuleImpl();
	
		ActionContext  ctx = ActionContext.getContext(); 
		 
		//调用业务逻辑层组件
		List<Share_link> allShare_linkList =  this.resLinkModule.checkAllResLink( (ctx.get("admin") != null) );
		
		//将获取的结果放入 session 中
		ctx.getSession().put("allShare_linkList", allShare_linkList);	    
		return SUCCESS;
	}
	
}
