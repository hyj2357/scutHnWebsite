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
		//����ҵ���߼�����������޸�����
		Admin ad = this.adminAdModule.setName( ((Admin)ctx.getSession().get("admin")).getAdmin_id(), admin_nameM );
		
		//��session�н��µ���Ϣ���ǵ�ԭ�е���Ϣ
		if( ad == null)  return ERROR;
		else{			
			 ctx.getSession().put("admin", ad);
			 return SUCCESS;
		}
	}
	
	
	public   void  validate(){
		
		//У�����Ա�޸ĺ������
		String regexAdmin_nameM = "^[\\u4E00-\\u9FA5]{2,10}$";
		if( !Pattern.matches(regexAdmin_nameM, this.admin_nameM ) )
		     this.addFieldError("admin_nameM", "����Ա����Ϊ����Ϊ2~10�ĵļ��������ַ�����");
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
