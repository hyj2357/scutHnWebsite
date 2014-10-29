package com.scuthnweb.action.adminuser;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.AdminUserImpl;
import com.scuthnweb.service.interf.AdminUser;

public class ModifyUserInfoAction extends ActionSupport{
	
	private AdminUser adminUser;
	
	private int    admin_id,
	               customer_id,
	               customer_sex,
	               customer_phone,
	               customer_qq;
    
	private String customer_name,
                   customer_password,
                   customer_grade,
                   customer_major,
                   customer_email,
                   customer_room;

	
	public  String execute(){
		
		this.adminUser = new AdminUserImpl();
	
		//��ȡ����Աid
	    ActionContext ctx = ActionContext.getContext();	    
	    this.setAdmin_id( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
	    
	    
	    if( this.adminUser.modifyUserInfo(admin_id, customer_id, customer_name, 
	    		                          customer_password, customer_sex, 
	    		                          customer_grade, customer_major, customer_phone, 
	    		                          customer_qq, customer_email, customer_room) )
	    	   return SUCCESS;
	    else   return ERROR;	    	    
	}
	
		
	public  void   validate(){
		
		//У���û��꼶��ʽ
		String regexGrade = "^2([\\w]{3})$";
		if( !Pattern.matches(regexGrade, this.customer_grade) )
				this.addFieldError("customer_grade", "�û��꼶��ʽΪ��2XXX��");

								
		//У���û�רҵ
		String regexMajor = "^([\\u4E00-\\u9FA5]{2,50})$";
		if( !Pattern.matches(regexMajor, this.customer_major) )
				this.addFieldError("customer_major", "�û�רҵΪ����2~50�ļ��������ַ���");
								
		/**
		* int ̫С�ˣ�������32λ�����޷����ճ���Ϊ11���������֣�����
		*/
		//У���û��ֻ�����
		String regexPhone = "^([\\d]{11})$";
		if( !Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) )){
			System.out.println(Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) ));
			this.addFieldError("customer_phone", "�绰���볤�ȴ��󣡵绰����Ϊ����11�������ַ���");
		}
						
								
		//У���û�qq����
		String regexQq = "^(\\d{5,20})$";
		if( !Pattern.matches(regexQq, String.valueOf(this.customer_qq)) )
			this.addFieldError("customer_qq", "qq��ʽΪ����5~11�������ַ���");;
								
								
								
		//��������Ƿ����������ʽ
		String regexEmail = "^(\\w{2,25}@)(\\w{2,25})(\\.(com|cn))$";	    
		if(!Pattern.matches(regexEmail, this.customer_email))
			this.addFieldError("customer_email", "�����ʽ���Ϸ��������ʽӦΪxxx(���ֻ���ĸ,2-25����ĸ)@xxx(���ֻ���ĸ,2-25����ĸ).com/cn");
							    
		if( this.customer_email.length()>50 )
			this.addFieldError("customer_email", "���䳤�Ȳ��ó���50");
								
								
		//У���û������
		String regexRoom = "^([\\u4E00-\\u9FA5\\w]{5,20})$";
		if(!Pattern.matches(regexRoom, this.customer_room))
			this.addFieldError("customer_room", "�������Ϊ5~20�ļ������Ļ����֣���ĸ��ɵ��ַ���" );
	}

	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

}
