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
		
		//调用业务逻辑层组件
		List<Need>  allNeedList = this.needModule.checkAllNeed( (ctx.getSession().get("admin") != null) );
		
		//将结果 needList 放入session对象中
		ctx.getSession().put("allNeedList", allNeedList);
		return SUCCESS;
	}

}
