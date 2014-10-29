package com.scuthnweb.action.useradmin;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.UserAdminImpl;
import com.scuthnweb.service.interf.UserAdmin;

public class UserIDLoginAction extends ActionSupport{
	private  UserAdmin   userAdmin;
	
	private  int         customer_id; 
	private  String      customer_name;
    private  String      customer_password;
    
    
	
	public String execute(){
		
		this.userAdmin = new UserAdminImpl();
		
		//调用业务逻辑层组件
		BaseCustomer userLoginInfo = this.userAdmin.userIDLogin(customer_id, customer_name, customer_password);
		
		if( userLoginInfo == null) return ERROR;
		
		//将返回结果 userLoginInfo 放入 session
		ActionContext ctx = ActionContext.getContext();		
		ctx.getSession().put("customer", userLoginInfo);
		return SUCCESS;
	  }
	
	
	public void validate(){
			
			//检测用户id是否合法	
		    String regexId = "^([\\d]{5,20})$";
		    if( !Pattern.matches( regexId, String.valueOf(this.customer_id) ))
		    	this.addFieldError("customer_id", "用户id由5~20位的数字组成");
			
		    //检测用户姓名是否符合中文正则表达式
			String regexName = "^([\\u4E00-\\u9FA5]{2,4})$";
		    if( !Pattern.matches(regexName, this.customer_name))
		        this.addFieldError("customer_name","用户姓名必须为长度为2~4的中文字符串");
			
		    //检测用户密码是否合法
		    String regexPassword = "^\\w{5,20}$";
		    if( !Pattern.matches(regexPassword, this.customer_password) )
		    	this.addFieldError("customer_password", "用户密码格式错误，必须为长度为5~20的英文字母或数字组成的字符串");
    }
	
  
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	
}
