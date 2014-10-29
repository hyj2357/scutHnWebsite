package com.scuthnweb.action.needmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class PostNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	private String need_name, need_content;
	private int    need_publisher;
	
	public String execute(){
	    
		this.needModule = new NeedModuleImpl();
	    
		//��session�л�ȡ��ǰ��������� �û��� ����Ա id
		ActionContext ctx = ActionContext.getContext();
	    if( ctx.getSession().get("customer") != null)
	          this.setNeed_publisher( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
	    else  this.setNeed_publisher( ((Admin)ctx.getSession().get("customer")).getAdmin_id() );
		
		//����ҵ���߼������
	    if( this.needModule.postNeed(need_name, need_content, need_publisher))
	    	  return SUCCESS;
	    else  return ERROR;
	}
	
d
��Ŀ����7
	public void  validate(){
		
		//�����������Ƿ����������ʽ
		String regexName = "^([\\u4E00-\\u9FA5\\w]{5,30})$";
		if( !Pattern.matches(regexName, this.need_name))
				this.addFieldError("need_name","����������Ϊ����Ϊ5~30�ļ������Ļ�Ӣ����ĸ��������ɵ��ַ���");
			    
		//У����������
		String regexContent = "^([\\u4E00-\\u9FA5\\w\\u0022-\\u002F]{10,255})$";
		if( !Pattern.matches(regexContent, this.need_content))
				this.addFieldError("need_content","�������ݱ���Ϊ����Ϊ10~255�ļ������Ļ�Ӣ����ĸ,�����Լ����õı�������ɵ��ַ���");
		
	}
	
	
	public String getNeed_name() {
		return need_name;
	}
	public void setNeed_name(String need_name) {
		this.need_name = need_name;
	}
	
	
	public String getNeed_content() {
		return need_content;
	}
	public void setNeed_content(String need_content) {
		this.need_content = need_content;
	}
	
	
	public int getNeed_publisher() {
		return need_publisher;
	}
	public void setNeed_publisher(int need_publisher) {
		this.need_publisher = need_publisher;
	}

}
