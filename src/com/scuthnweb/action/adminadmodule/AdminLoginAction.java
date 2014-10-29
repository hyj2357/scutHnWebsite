package com.scuthnweb.action.adminadmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.AdminAdModuleImpl;
import com.scuthnweb.service.interf.AdminAdModule;

public class AdminLoginAction extends ActionSupport{
	 
	 private  AdminAdModule adminAdModule;
	 
	 private  int    admin_id;
	 private  String admin_password;
	 
	 public String execute(){
		 
		 this.adminAdModule = new AdminAdModuleImpl();
	 
		 Admin ad =  this.adminAdModule.adminLogin(admin_id, admin_password);
	     
		 if( ad == null) return ERROR;
		 else{
			   ActionContext ctx = ActionContext.getContext();
			   ctx.getSession().put("admin", ad);
			   return SUCCESS;
		 }
	 }

	 
    public void validate(){
    	
    	//У�����Աid
    	String regexAdmin_id = "^[0-9]{11}$";
    	if( !Pattern.matches(regexAdmin_id, Integer.toString(this.admin_id)) )
            this.addFieldError("admin_id", "����ԱidΪ����Ϊ11�����ִ���");
    	
    	//У�����Ա����
    	String regexAdmin_password = "^[\\w]{1,32}$";
    	if( !Pattern.matches(regexAdmin_password, this.admin_password))
           this.addFieldError("admin_password", "����Ϊ1~32λ��Ӣ�Ļ�������ɵ��ַ�����");
    }
    
  
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	 
	 
}
