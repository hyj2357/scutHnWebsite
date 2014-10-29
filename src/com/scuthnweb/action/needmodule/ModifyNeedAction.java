package com.scuthnweb.action.needmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class ModifyNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	private int    need_id;
	private String need_name, need_content;
	
	
	public String execute(){
		
		this.needModule = new NeedModuleImpl();
		
		if( this.needModule.modifyNeed(need_id, need_name, need_content) )
			  return SUCCESS;
		else  return ERROR;
	}
	
d
项目问题7
	public void validate(){
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
	
	
	public int getNeed_id() {
		return need_id;
	}
	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}

}
