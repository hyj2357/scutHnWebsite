package com.scuthnweb.action.needmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class ModifyNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	private int    need_id;
	private String need_name, need_content;
	
	
	public String execute(){
		
		this.needModule = new NeedModuleImpl();
		
		if( this.needModule.modifyNeed(need_id, need_name, need_content) )
			  return SUCCESS;
		else  return ERROR;
	}
	
d
��Ŀ����7
	public void validate(){
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
	
	
	public int getNeed_id() {
		return need_id;
	}
	public void setNeed_id(int need_id) {
		this.need_id = need_id;
	}

}
