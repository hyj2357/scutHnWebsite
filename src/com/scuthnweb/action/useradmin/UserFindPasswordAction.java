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
         
 	    //����û������Ƿ��������������ʽ
 	    String regexName ="^([\\u4E00-\\u9FA5\\uF900-\\uFA2D]{2,4})$";
 	    if( !Pattern.matches(regexName, this.customer_name));
 	        this.addFieldError("customer_name","�û���������Ϊ����Ϊ2~4�������ַ���");
 	    
 	    //��������Ƿ����������ʽ
 	    String regexEmail = "^(\\w{2,25}@)(\\w{2,25})(\\.(com|cn))$";	    
 	    if(!Pattern.matches(regexEmail, this.customer_email))
 	    	this.addFieldError("customer_email", "�����ʽ���Ϸ��������ʽӦΪxxx(���ֻ���ĸ,2-25����ĸ)@xxx(���ֻ���ĸ,2-25����ĸ).com/cn");
 	    
 	    if( this.customer_email.length()>50 )
 	    	this.addFieldError("customer_email", "���䳤�Ȳ��ó���50");
 	    
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