package com.scuthnweb.action.needmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class PostNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	private String need_name, need_content;
	private int    need_publisher;
	
	public String execute(){
	    
		this.needModule = new NeedModuleImpl();
	    
		//从session中获取当前发布需求的 用户或 管理员 id
		ActionContext ctx = ActionContext.getContext();
	    if( ctx.getSession().get("customer") != null)
	          this.setNeed_publisher( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
	    else  this.setNeed_publisher( ((Admin)ctx.getSession().get("customer")).getAdmin_id() );
		
		//调用业务逻辑层组件
	    if( this.needModule.postNeed(need_name, need_content, need_publisher))
	    	  return SUCCESS;
	    else  return ERROR;
	}
	
d
项目问题7
	public void  validate(){
		
		//检测需求标题是否符合正则表达式
		String regexName = "^([\\u4E00-\\u9FA5\\w]{5,30})$";
		if( !Pattern.matches(regexName, this.need_name))
				this.addFieldError("need_name","需求标题必须为长度为5~30的简体中文或英文字母与数字组成的字符串");
			    
		//校检需求内容
		String regexContent = "^([\\u4E00-\\u9FA5\\w\\u0022-\\u002F]{10,255})$";
		if( !Pattern.matches(regexContent, this.need_content))
				this.addFieldError("need_content","需求内容必须为长度为10~255的简体中文或英文字母,数字以及常用的标点符号组成的字符串");
		
	}
	
	
	public String getNeed_name() {
		return need_name;
	}
	public void setNeed_name(String need_name) {
		this.need_name = need_name;
	}
	
	
	public String getNeed_content() {
		return need_content;
	}
	public void setNeed_content(String need_content) {
		this.need_content = need_content;
	}
	
	
	public int getNeed_publisher() {
		return need_publisher;
	}
	public void setNeed_publisher(int need_publisher) {
		this.need_publisher = need_publisher;
	}

}
