package com.scuthnweb.action.useradmin;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.impl.UserAdminImpl;
import com.scuthnweb.service.interf.UserAdmin;



@SuppressWarnings("serial")
public class UserFindPasswordAction extends ActionSupport{
	 private  UserAdmin           userAdmin;
	 private  String              customer_name;
	 private  String              customer_email;
	 
	 
     public   String execute(){
    	 
    	 this.userAdmin = new UserAdminImpl();
    	 
    	 if(userAdmin.userFindPassWord(customer_name, customer_email))  
    		      return SUCCESS;
    	 else     return ERROR;
    	 
     }

     
     public void validate(){
         
 	    //检测用户姓名是否符合中文正则表达式
 	    String regexName ="^([\\u4E00-\\u9FA5\\uF900-\\uFA2D]{2,4})$";
 	    if( !Pattern.matches(regexName, this.customer_name));
 	        this.addFieldError("customer_name","用户姓名必须为长度为2~4的中文字符串");
 	    
 	    //检测邮箱是否符合正则表达式
 	    String regexEmail = "^(\\w{2,25}@)(\\w{2,25})(\\.(com|cn))$";	    
 	    if(!Pattern.matches(regexEmail, this.customer_email))
 	    	this.addFieldError("customer_email", "邮箱格式不合法，邮箱格式应为xxx(数字或字母,2-25个字母)@xxx(数字或字母,2-25个字母).com/cn");
 	    
 	    if( this.customer_email.length()>50 )
 	    	this.addFieldError("customer_email", "邮箱长度不得超过50");
 	    
 	}
     
     

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	
}