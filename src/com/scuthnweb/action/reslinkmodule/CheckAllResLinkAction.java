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
		 
		//����ҵ���߼������
		List<Share_link> allShare_linkList =  this.resLinkModule.checkAllResLink( (ctx.get("admin") != null) );
		
		//����ȡ�Ľ������ session ��
		ctx.getSession().put("allShare_linkList", allShare_linkList);	    
		return SUCCESS;
	}
	
}
