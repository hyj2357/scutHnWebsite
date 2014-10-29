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
		
		//��ȡ��ǰ�鿴������Ĺ���Աid
		this.setNote__publisher( ((Admin)ctx.getSession().get("admin")).getAdmin_id() );
		
		//����ҵ���߼������
		List<Note> postNoteList = this.needModule.checkPostNote(note__publisher);
	    
		//����� postNoteList ���뵽 session ��
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
