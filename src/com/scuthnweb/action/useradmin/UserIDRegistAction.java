package com.scuthnweb.action.useradmin;

import java.sql.SQLException;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.UserAdminImpl;
import com.scuthnweb.service.interf.UserAdmin;



public class UserIDRegistAction extends ActionSupport{
	
	private UserAdmin userAdmin;
	
	private String customer_name;
	private String customer_password; 
	private String invite_code_Content;
	private int    customer_sex;
	private String customer_grade; 
	private String customer_major;
	private int    customer_phone; 
	private int    customer_qq; 
	private String customer_email;
	private String customer_room;
	
	
	public String execute(){
		
		this.userAdmin = new UserAdminImpl();
		
		//调用业务逻辑层组件接口
		BaseCustomer userRegisterInfo = this.userAdmin.userIDResgist(customer_name, customer_password, invite_code_Content, customer_sex, customer_grade, customer_major, customer_phone, customer_qq, customer_email, customer_room);
		
		if( userRegisterInfo == null) return ERROR;
		
		//将返回的结果 userRegisterInfo 放入到session 中
		ActionContext ctx = ActionContext.getContext();		
		ctx.getSession().put("customer", userRegisterInfo);
		return SUCCESS;		
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
	
	
	public String getInvite_code_Content() {
		return invite_code_Content;
	}
	public void setInvite_code_Content(String invite_code_Content) {
		this.invite_code_Content = invite_code_Content;
	}
	
	
	public int getCustomer_sex() {
		return customer_sex;
	}
	public void setCustomer_sex(int customer_sex) {
		this.customer_sex = customer_sex;
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

	public void validate(){
		//检测用户姓名是否符合中文正则表达式
		String regexName = "^([\\u4E00-\\u9FA5]{2,4})$";
	    if( !Pattern.matches(regexName, this.customer_name))
			    this.addFieldError("customer_name","用户姓名必须为长度为2~4的简体中文字符串");
				
		//检测用户密码是否合法
		String regexPassword = "^\\w{5,20}$";
		if( !Pattern.matches(regexPassword, String.valueOf( this.customer_password )) )
			    this.addFieldError("customer_password", "用户密码格式错误，必须为长度为5~20的英文字母或数字组成的字符串");
		
		
		/**
		 * 完成 invite_code_ContentDao 接口以完成该步校检！！！
		 */
		//校检邀请码
		String invite_code_Content;
		
		
		
		//校检用户年级格式 customer_major
		String regexGrade = "^2([\\w]{3})$";
		if( !Pattern.matches(regexGrade, this.customer_grade) )
			    this.addFieldError("customer_grade", "用户年级格式为：2XXX！");
		
		//校检用户专业
		String regexMajor = "^([\\u4E00-\\u9FA5]{2,50})$";
		if( !Pattern.matches(regexMajor, this.customer_major) )
			    this.addFieldError("customer_major", "用户专业为长度2~50的简体中文字符串");
		String customer_major;
		
		/**
		 * int 太小了！！！在32位机上无法接收长度为11的整型数字！！！
		 */
		//校检用户手机号码 customer_phone
		String regexPhone = "^([\\d]{11})$";
		if( !Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) )){
			   System.out.println(Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) ));
			   this.addFieldError("customer_phone", "电话号码长度错误！电话号码为长度11的数字字符串");
		         
		}
		
		
		//校检用户qq号码 customer_qq
		String regexQq = "^(\\d{5,20})$";
		if( !Pattern.matches(regexQq, String.valueOf(this.customer_qq)) )
			this.addFieldError("customer_qq", "qq格式为长度5~11的数字字符串");;
		
		
		
		//检测邮箱是否符合正则表达式 customer_email
	    String regexEmail = "^(\\w{2,25}@)(\\w{2,25})(\\.(com|cn))$";	    
	    if(!Pattern.matches(regexEmail, this.customer_email))
	    	this.addFieldError("customer_email", "邮箱格式不合法，邮箱格式应为xxx(数字或字母,2-25个字母)@xxx(数字或字母,2-25个字母).com/cn");
	    
	    if( this.customer_email.length()>50 )
	    	this.addFieldError("customer_email", "邮箱长度不得超过50");
		
		
		//校检用户宿舍号 customer_room
		String regexRoom = "^([\\u4E00-\\u9FA5\\w]{5,20})$";
		if(!Pattern.matches(regexRoom, this.customer_room))
			this.addFieldError("customer_room", "宿舍号码为5~20的简体中文或数字，字母组成的字符串" );
		
	}
	
}
