package com.scuthnweb.action.reslinkmodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Customer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.impl.ResLinkModuleImpl;
import com.scuthnweb.service.interf.ResLinkModule;

public class CheckUploadAction extends ActionSupport{
	
	private ResLinkModule resLinkModule;
	
	private int share_link_publisher;
		

	public String execute(){
   		
	  this.resLinkModule = new ResLinkModuleImpl();	
	
	 //��session �л�ȡ��ǰ���г������������������ͨ�û������Ա id
	 ActionContext ctx = ActionContext.getContext();
	 if( ctx.getSession().get("admin") != null)  
			this.setShare_link_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
	 else    this.setShare_link_publisher( ((BaseCustomer)ctx.getSession().get("customer")).getId() ); 
	
	 
	 //����ҵ���߼������
	 List<Share_link> uploadLinkList =  this.resLinkModule.checkUploadLink(share_link_publisher);
	 
	 //����ȡ�Ľ������ session ��
	 ctx.getSession().put("uploadLinkList", uploadLinkList);	 
	 return SUCCESS;
	}

	public int getShare_link_publisher() {
		return share_link_publisher;
	}
	public void setShare_link_publisher(int share_link_publisher) {
		this.share_link_publisher = share_link_publisher;
	}

}