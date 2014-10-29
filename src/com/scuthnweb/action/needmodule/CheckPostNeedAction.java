package com.scuthnweb.action.needmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Need;
import com.scuthnweb.service.impl.NeedModuleImpl;
import com.scuthnweb.service.interf.NeedModule;

public class CheckPostNeedAction extends ActionSupport{
	
	private NeedModule needModule;
	
	private int        need_publisher;
	
	public String execute(){
		
	    this.needModule = new NeedModuleImpl();	
	
	  //��session �л�ȡ��ǰ����鿴�Լ��������������ͨ�û������Ա id
	  ActionContext ctx = ActionContext.getContext();
	  if( ctx.getSession().get("admin") != null)  
	  		  this.setNeed_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
	  else    this.setNeed_publisher( ((Customer)ctx.getSession().get("customer")).getId() ); 
	  
	  //����ҵ���߼������
	  List<Need> postNeedList = this.needModule.checkPostNeed(need_publisher);
	  
	  //����õĽ�� postNeedList ����session ��
	  ctx.getSession().put("postNeedList", postNeedList);
	  return SUCCESS;
	}

	
	public int sNeed_publisher() {
		return need_publisher;
	}
	public void setNeed_publisher(int need_publisher) {
		this.need_publisher = need_publisher;
	}
	
}
