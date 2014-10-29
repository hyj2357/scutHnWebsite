package com.scuthnweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.scuthnweb.dao.impl.NoteDaoImpl;
import com.scuthnweb.dao.interf.AdminDao;
import com.scuthnweb.dao.interf.NoteDao;
import com.scuthnweb.domain.Note;
import com.scuthnweb.service.interf.NoteModule;

public class NoteModuleImpl implements NoteModule{

	private  AdminDao adminDao;
	private  NoteDao  noteDao;


	@Override
	public List<Note> checkAllNote( boolean isAdmin) {
		
		this.noteDao = new NoteDaoImpl();
			
		//调用 Dao 层方法
		//如果当前查看信息者为管理员
		//则返回所有的信息（包括上线与未上线）
		//如果是普通用户或游客
		//则返回当前上线的信息
		List<Note> allNoteList = (isAdmin) ? this.noteDao.findNoteM(-1, null, -1, null, -1,-1):this.noteDao.findNoteM(-1, null, -1, null, -1, 0);
		
		//allNoteList 为null
		//返回一个空list
		return (allNoteList==null) ? (new ArrayList<Note>()):allNoteList;
	}


	@Override
	public List<Note> checkPostNote(int note__publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//调用 Dao 层方法
		List<Note> postNoteList =  this.noteDao.findNoteM(-1, null, -1, null, note__publisher, -1);
		
		//postNoteList 为null
		//返回一个空list
		return (postNoteList==null)? (new ArrayList<Note>()) : postNoteList;
	}


	@Override
	public boolean modifyNote(int note_id, String note_name, int note_type, String note_content, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//调用 Dao 层方法
		//修改失败返回 false
		//反之返回 true		
		return  (this.noteDao.updateNote(note_id, -1, note_name, note_type, note_content, -1) == null) ? false:true;
	}

	d
    项目问题4	 	
	@Override
	public boolean offlineNote(int note_id, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//若该活动非该管理员发布的话
		//返回false
		if(this.noteDao.findNoteM(note_id, null, -1, null, note_publisher, -1)==null) return false;
		
		//调用 Dao 层方法
		//下线失败返回 false
		//反之返回 true
		return (this.noteDao.updateNote( note_id, -1, null, -1, null , 1) == null) ? false:true;
		
	}


	@Override
	public boolean postNote(String note_name, int note_type, String note_content, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//调用 Dao 层方法
		//发布失败返回 false
		//反之返回 true
		return ( this.noteDao.createNote(note_name, note_type, note_content, note_publisher) == null) ? false:true;
	}


	@Override
	public boolean deleteNote(int note_id, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//若该活动非该管理员发布的话
		//返回false
		if( this.noteDao.findNoteM(note_id, null, -1, null, note_publisher, -1)==null ) return false;
		
		//调用Dao相关方法删除信息
		return this.noteDao.deleteNote(note_id);
	}
	
}