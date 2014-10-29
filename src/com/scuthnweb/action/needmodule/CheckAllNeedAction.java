package com.scuthnweb.action.needmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class CheckAllNeedAction extends ActionSupport{
	
	private  NeedModule needModule;	
	
	public String execute(){
		
		this.needModule = new NeedModuleImpl();
	    
		ActionContext ctx  =ActionContext.getContext();
		
		//����ҵ���߼������
		List<Need>  allNeedList = this.needModule.checkAllNeed( (ctx.getSession().get("admin") != null) );
		
		//����� needList ����session������
		ctx.getSession().put("allNeedList", allNeedList);
		return SUCCESS;
	}

}
