package com.scuthnweb.action.reslinkmodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.ResLinkModuleImpl;
import com.scuthnweb.service.interf.ResLinkModule;

public class UploadLinkAction extends ActionSupport{
	
	private  ResLinkModule resLinkModule;


	private  int share_link_publisher;
	private String share_link_name, share_link_content;
	
	
	public String execute(){
		
	       this.resLinkModule = new ResLinkModuleImpl();	
	       
	       ActionContext ctx = ActionContext.getContext();
	       
	       //获取请求上传资源链接的用户或管理员id
   		   if(ctx.getSession().get("customer")!= null )
   			     this.setShare_link_publisher( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
   		   else  this.setShare_link_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
   	
	
	       if( this.resLinkModule.uploadLink(share_link_publisher, share_link_name, share_link_content))
	    	     return SUCCESS;
	       else  return ERROR;
	}
	
d	
项目问题7	
	//校验
	public void validate(){
		//校验链接名称
        String regexLinkName = "^[\\u4E00-\\u9FA5\\w]{2,20}$";
        if( !Pattern.matches(regexLinkName, this.share_link_name))
     	   this.addFieldError("链接名称为由简体中文，数字或英文字母组成2~20个字符长度的字符串！");
        
-项目问题7
	}
	

	public String getShare_link_name() {
		return share_link_name;
	}
	public void setShare_link_name(String share_link_name) {
		this.share_link_name = share_link_name;
	}


	public String getShare_link_content() {
		return share_link_content;
	}
	public void setShare_link_content(String share_link_content) {
		this.share_link_content = share_link_content;
	}

	public int getShare_link_publisher() {
		return share_link_publisher;
	}
	public void setShare_link_publisher(int share_link_publisher) {
		this.share_link_publisher = share_link_publisher;
	}	
    
}
