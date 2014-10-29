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
		
		//����ҵ���߼�������ӿ�
		BaseCustomer userRegisterInfo = this.userAdmin.userIDResgist(customer_name, customer_password, invite_code_Content, customer_sex, customer_grade, customer_major, customer_phone, customer_qq, customer_email, customer_room);
		
		if( userRegisterInfo == null) return ERROR;
		
		//�����صĽ�� userRegisterInfo ���뵽session ��
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
		//����û������Ƿ��������������ʽ
		String regexName = "^([\\u4E00-\\u9FA5]{2,4})$";
	    if( !Pattern.matches(regexName, this.customer_name))
			    this.addFieldError("customer_name","�û���������Ϊ����Ϊ2~4�ļ��������ַ���");
				
		//����û������Ƿ�Ϸ�
		String regexPassword = "^\\w{5,20}$";
		if( !Pattern.matches(regexPassword, String.valueOf( this.customer_password )) )
			    this.addFieldError("customer_password", "�û������ʽ���󣬱���Ϊ����Ϊ5~20��Ӣ����ĸ��������ɵ��ַ���");
		
		
		/**
		 * ��� invite_code_ContentDao �ӿ�����ɸò�У�죡����
		 */
		//У��������
		String invite_code_Content;
		
		
		
		//У���û��꼶��ʽ customer_major
		String regexGrade = "^2([\\w]{3})$";
		if( !Pattern.matches(regexGrade, this.customer_grade) )
			    this.addFieldError("customer_grade", "�û��꼶��ʽΪ��2XXX��");
		
		//У���û�רҵ
		String regexMajor = "^([\\u4E00-\\u9FA5]{2,50})$";
		if( !Pattern.matches(regexMajor, this.customer_major) )
			    this.addFieldError("customer_major", "�û�רҵΪ����2~50�ļ��������ַ���");
		String customer_major;
		
		/**
		 * int ̫С�ˣ�������32λ�����޷����ճ���Ϊ11���������֣�����
		 */
		//У���û��ֻ����� customer_phone
		String regexPhone = "^([\\d]{11})$";
		if( !Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) )){
			   System.out.println(Pattern.matches(regexPhone, String.valueOf( this.customer_phone ) ));
			   this.addFieldError("customer_phone", "�绰���볤�ȴ��󣡵绰����Ϊ����11�������ַ���");
		         
		}
		
		
		//У���û�qq���� customer_qq
		String regexQq = "^(\\d{5,20})$";
		if( !Pattern.matches(regexQq, String.valueOf(this.customer_qq)) )
			this.addFieldError("customer_qq", "qq��ʽΪ����5~11�������ַ���");;
		
		
		
		//��������Ƿ����������ʽ customer_email
	    String regexEmail = "^(\\w{2,25}@)(\\w{2,25})(\\.(com|cn))$";	    
	    if(!Pattern.matches(regexEmail, this.customer_email))
	    	this.addFieldError("customer_email", "�����ʽ���Ϸ��������ʽӦΪxxx(���ֻ���ĸ,2-25����ĸ)@xxx(���ֻ���ĸ,2-25����ĸ).com/cn");
	    
	    if( this.customer_email.length()>50 )
	    	this.addFieldError("customer_email", "���䳤�Ȳ��ó���50");
		
		
		//У���û������ customer_room
		String regexRoom = "^([\\u4E00-\\u9FA5\\w]{5,20})$";
		if(!Pattern.matches(regexRoom, this.customer_room))
			this.addFieldError("customer_room", "�������Ϊ5~20�ļ������Ļ����֣���ĸ��ɵ��ַ���" );
		
	}
	
}
