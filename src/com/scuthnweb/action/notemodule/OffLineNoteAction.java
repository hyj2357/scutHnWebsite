package com.scuthnweb.action.notemodule;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.service.impl.NoteModuleImpl;
import com.scuthnweb.service.interf.NoteModule;

public class OffLineNoteAction extends  ActionSupport{
	
	private  NoteModule noteModule;
	
	private  int        note_id, note_publisher;

	
	public   String execute(){
		
		this.noteModule = new NoteModuleImpl();
	    		
		ActionContext ctx = ActionContext.getContext();
		
		//获取管理员 id
		this.setNote_publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		
		//调用业务逻辑层组件实现下线信息
		if( this.noteModule.offlineNote(note_id, note_publisher))
			  return SUCCESS;
		else  return ERROR;
	}
	

	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}


	public int getNote_publisher() {
		return note_publisher;
	}
	public void setNote_publisher(int note_publisher) {
		this.note_publisher = note_publisher;
	}

}
