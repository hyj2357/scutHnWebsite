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
		
		//����ҵ���߼������
		ActionContext ctx = ActionContext.getContext();
		List<Share_link> verifyLinkList = this.resLinkModule.checkVerifyLink();
	    
		//����ȡ�Ľ������ session ��
		ctx.getSession().put("verifyLinkList", verifyLinkList);
		return SUCCESS;
	}
	
}
