package com.scuthnweb.action.needmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class CheckAcNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	
	private int need_reciever;

	
	public String execute(){
		
		this.needModule = new NeedModuleImpl();
	
		//��session �л�ȡ��ǰ���г������������������ͨ�û������Ա id
		ActionContext ctx = ActionContext.getContext();
		if( ctx.getSession().get("admin") != null)  
				this.setNeed_reciever( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		else    this.setNeed_reciever( ((Customer)ctx.getSession().get("customer")).getId() ); 
		
		//����ҵ���߼�������
		List<Need> acNeedList = this.needModule.checkAcNeed(need_reciever);
	    ctx.getSession().put("acNeedList", acNeedList);
	    
	    return SUCCESS;
	}
	
	public void setNeed_reciever(int need_reciever) {
		this.need_reciever = need_reciever;
	}
	
	

}
