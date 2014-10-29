package com.scuthnweb.action.notemodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Admin;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.impl.NoteModuleImpl;
import com.scuthnweb.service.interf.NoteModule;

public class CheckPostNoteAction extends ActionSupport{
	
	private NoteModule needModule;
	
	private  int note__publisher;


	public String execute(){
		
		this.needModule = new NoteModuleImpl();		
		
		ActionContext ctx = ActionContext.getContext();
		
		//获取当前查看发布活动的管理员id
		this.setNote__publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		
		//调用业务逻辑层组件
		List<Note> postNoteList = this.needModule.checkPostNote(note__publisher);
	    
		//将结果 postNoteList 放入到 session 中
		ctx.getSession().put("postNoteList", postNoteList);
		return SUCCESS;
	}

	
	public int getNote__publisher() {
		return note__publisher;
	}
	public void setNote__publisher(int note__publisher) {
		this.note__publisher = note__publisher;
	}
}
