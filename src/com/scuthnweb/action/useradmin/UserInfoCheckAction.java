package com.scuthnweb.action.useradmin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.service.impl.UserAdminImpl;
import com.scuthnweb.service.interf.UserAdmin;

public class UserInfoCheckAction extends ActionSupport{
	
	private UserAdmin userAdmin;
	
	public  String  execute(){
		
		this.userAdmin = new UserAdminImpl();
		
		//��ȡ session �е� customer_id
		ActionContext ctx = ActionContext.getContext();
		int customer_id = ((BaseCustomer)ctx.getSession().get("customer")).getId();
		
		//������Ӧ�� ҵ���߼������
		//��ȡ��Ӧ���û���Ϣ
		Customer userCheckInfo = this.userAdmin.userInfoCheck( customer_id );
	    
		if( userCheckInfo == null )  return ERROR;
		else{
		     ctx.getSession().put("customerCheckInfo", userCheckInfo);
		     return SUCCESS;
		}
	}

}
