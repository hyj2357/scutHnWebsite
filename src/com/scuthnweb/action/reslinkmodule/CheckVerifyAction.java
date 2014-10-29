package com.scuthnweb.action.reslinkmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.impl.ResLinkModuleImpl;
import com.scuthnweb.service.interf.ResLinkModule;

public class CheckVerifyAction extends ActionSupport{
	
	private ResLinkModule resLinkModule;

	public  String execute(){
	   
		this.resLinkModule = new ResLinkModuleImpl();
		
		//调用业务逻辑层组件
		ActionContext ctx = ActionContext.getContext();
		List<Share_link> verifyLinkList = this.resLinkModule.checkVerifyLink();
	    
		//将获取的结果放入 session 中
		ctx.getSession().put("verifyLinkList", verifyLinkList);
		return SUCCESS;
	}
	
}
