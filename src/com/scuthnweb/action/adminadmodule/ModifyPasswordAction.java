package com.scuthnweb.action.adminadmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.AdminAdModuleImpl;
import com.scuthnweb.service.interf.AdminAdModule;

public class ModifyPasswordAction extends ActionSupport{
	
	private  AdminAdModule adminAdModule;
	
	private  String admin_password, admin_passwordM;
	
	
	public String execute(){
		
	    this.adminAdModule = new AdminAdModuleImpl();	
	    
	    //����ҵ���߼������
	    ActionContext ctx = ActionContext.getContext();
	    if( this.adminAdModule.modifyPassword( ((Admin)ctx.getSession().get("admin")).getAdmin_id(), admin_password, admin_passwordM))
	    	  return SUCCESS;
	    else  return ERROR;
	}
	
	
	public void validate(){
				
		//У�����Ա����
		String regexAdmin_password = "^[\\w]{1,32}$";
		if( !Pattern.matches(regexAdmin_password, this.admin_password))
	           this.addFieldError("admin_password", "����Ϊ1~32λ��Ӣ�Ļ�������ɵ��ַ�����");
		
		//У�����Ա������
		String regexAdmin_passwordM = "^[\\w]{1,32}$";
		if( !Pattern.matches(regexAdmin_passwordM, this.admin_passwordM))
	           this.addFieldError("admin_passwordM", "����Ϊ1~32λ��Ӣ�Ļ�������ɵ��ַ�����");
	}
	
	
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	
	public String getAdmin_passwordM() {
		return admin_passwordM;
	}
	public void setAdmin_passwordM(String admin_passwordM) {
		this.admin_passwordM = admin_passwordM;
	}

}
