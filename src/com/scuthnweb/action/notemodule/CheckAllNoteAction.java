package com.scuthnweb.action.notemodule;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.impl.NoteModuleImpl;
import com.scuthnweb.service.interf.NoteModule;

public class CheckAllNoteAction extends ActionSupport{
	
	private NoteModule noteModule;

	public String execute(){
		
		this.noteModule = new NoteModuleImpl();
	
		ActionContext ctx = ActionContext.getContext();
		
		//调用业务逻辑层组件
	    List<Note> allNoteList =  this.noteModule.checkAllNote( (ctx.getSession().get("admin")!=null));
	    
	    ctx.getSession().put("allNoteList", allNoteList);	    
	    return SUCCESS;
	}
}
