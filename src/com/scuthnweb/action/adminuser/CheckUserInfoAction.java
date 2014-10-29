package com.scuthnweb.action.adminuser;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.AdminUserImpl;
import com.scuthnweb.service.interf.AdminUser;

public class CheckUserInfoAction extends ActionSupport{
	
	private AdminUser adminUser;
	private String customer_name, customer_grade, customer_major, customer_email, customer_room;
    private int    customer_id,customer_sex, customer_phone, customer_qq;
   
    

	public String execute(){
		
		this.adminUser = new AdminUserImpl();
		
		//调用业务逻辑层组件
		List<Customer> userInfoList = this.adminUser.checkUserInfo(customer_id, customer_name, customer_sex, customer_grade, customer_major, customer_phone, customer_qq, customer_email, customer_room);
	    
		//将结果放入 session 中
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("userInfoList", userInfoList);
		return SUCCESS;
	}
    
	public void validate(){
	     	
	
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


	public String getCustomer_grade() {
		return customer_grade;
	}


	public void setCustomer_grade(String customer_grade) {
		this.customer_grade = customer_grade;
	}


	public String getCustomer_major() {
		return customer_major;
	}


	public void setCustomer_major(String customer_major) {
		this.customer_major = customer_major;
	}


	public String getCustomer_email() {
		return customer_email;
	}


	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}


	public String getCustomer_room() {
		return customer_room;
	}


	public void setCustomer_room(String customer_room) {
		this.customer_room = customer_room;
	}


	public int getCustomer_sex() {
		return customer_sex;
	}


	public void setCustomer_sex(int customer_sex) {
		this.customer_sex = customer_sex;
	}


	public int getCustomer_phone() {
		return customer_phone;
	}


	public void setCustomer_phone(int customer_phone) {
		this.customer_phone = customer_phone;
	}


	public int getCustomer_qq() {
		return customer_qq;
	}


	public void setCustomer_qq(int customer_qq) {
		this.customer_qq = customer_qq;
	}

}
