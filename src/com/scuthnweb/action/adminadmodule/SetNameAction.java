package com.scuthnweb.action.adminadmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.AdminAdModuleImpl;
import com.scuthnweb.service.interf.AdminAdModule;

public class SetNameAction extends ActionSupport{
	
	private  AdminAdModule adminAdModule;

	private  int    admin_id;
	private  String admin_nameM;
	
	public   String  execute(){
		
		this.adminAdModule = new AdminAdModuleImpl();
		
        ActionContext ctx = ActionContext.getContext();
		//调用业务逻辑层组件方法修改名称
		Admin ad = this.adminAdModule.setName( ((Admin)ctx.getSession().get("admin")).getAdmin_id(), admin_nameM );
		
		//在session中将新的信息覆盖掉原有的信息
		if( ad == null)  return ERROR;
		else{			
			 ctx.getSession().put("admin", ad);
			 return SUCCESS;
		}
	}
	
	
	public   void  validate(){
		
		//校验管理员修改后的名称
		String regexAdmin_nameM = "^[\\u4E00-\\u9FA5]{2,10}$";
		if( !Pattern.matches(regexAdmin_nameM, this.admin_nameM ) )
		     this.addFieldError("admin_nameM", "管理员名称为长度为2~10的的简体中文字符串！");
	}

	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_nameM() {
		return admin_nameM;
	}
	public void setAdmin_nameM(String admin_nameM) {
		this.admin_nameM = admin_nameM;
	}
	
}
