package com.scuthnweb.action.reslinkmodule;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.BaseCustomer;
import com.scuthnweb.domain.Share_link;
import com.scuthnweb.service.impl.ResLinkModuleImpl;
import com.scuthnweb.service.interf.ResLinkModule;

public class UpdateLinkAction extends ActionSupport{

	private ResLinkModule resLinkModule;
	
	private int    share_link_id, share_link_publisher;
    private String share_link_name,share_link_Content;

    
    public String execute(){
    	
        	this.resLinkModule = new ResLinkModuleImpl();
        	
        	ActionContext ctx  = ActionContext.getContext();
            
            //��ȡ�����޸ĸ�����Դ���ӵ��û������Աid
    	    if(ctx.getSession().get("customer")!= null )
    			  this.setShare_link_publisher( ((BaseCustomer)ctx.getSession().get("customer")).getId() );
    	    else  this.setShare_link_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
    		
    		
    	    if( this.resLinkModule.updateLink(share_link_id, share_link_publisher, share_link_name, share_link_Content))
    			  return SUCCESS;
    		else  return ERROR;
    }
    
d    
��Ŀ����7    
    //У�鷽��
    public  void  validate(){
    	        
           //У����������
           String regexLinkName = "^[\\u4E00-\\u9FA5\\w]{2,20}$";
           if( !Pattern.matches(regexLinkName, this.share_link_name))
        	   this.addFieldError("share_link_name","��������Ϊ�ɼ������ģ����ֻ�Ӣ����ĸ���2~20���ַ����ȵ��ַ�����");
           

    }
    
    

	public int getShare_link_id() {
		return share_link_id;
	}
	public void setShare_link_id(int share_link_id) {
		this.share_link_id = share_link_id;
	}


	public int getShare_link_publisher() {
		return share_link_publisher;
	}
	public void setShare_link_publisher(int share_link_publisher) {
		this.share_link_publisher = share_link_publisher;
	}


	public String getShare_link_name() {
		return share_link_name;
	}
	public void setShare_link_name(String share_link_name) {
		this.share_link_name = share_link_name;
	}


	public String getShare_link_Content() {
		return share_link_Content;
	}
	public void setShare_link_Content(String share_link_Content) {
		this.share_link_Content = share_link_Content;
	}
	
}
