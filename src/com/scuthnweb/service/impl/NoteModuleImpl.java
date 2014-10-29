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
			
		//���� Dao �㷽��
		//�����ǰ�鿴��Ϣ��Ϊ����Ա
		//�򷵻����е���Ϣ������������δ���ߣ�
		//�������ͨ�û����ο�
		//�򷵻ص�ǰ���ߵ���Ϣ
		List<Note> allNoteList = (isAdmin) ? this.noteDao.findNoteM(-1, null, -1, null, -1,-1):this.noteDao.findNoteM(-1, null, -1, null, -1, 0);
		
		//allNoteList Ϊnull
		//����һ����list
		return (allNoteList==null) ? (new ArrayList<Note>()):allNoteList;
	}


	@Override
	public List<Note> checkPostNote(int note__publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//���� Dao �㷽��
		List<Note> postNoteList =  this.noteDao.findNoteM(-1, null, -1, null, note__publisher, -1);
		
		//postNoteList Ϊnull
		//����һ����list
		return (postNoteList==null)? (new ArrayList<Note>()) : postNoteList;
	}


	@Override
	public boolean modifyNote(int note_id, String note_name, int note_type, String note_content, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//���� Dao �㷽��
		//�޸�ʧ�ܷ��� false
		//��֮���� true		
		return  (this.noteDao.updateNote(note_id, -1, note_name, note_type, note_content, -1) == null) ? false:true;
	}

	d
    ��Ŀ����4	 	
	@Override
	public boolean offlineNote(int note_id, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//���û�Ǹù���Ա�����Ļ�
		//����false
		if(this.noteDao.findNoteM(note_id, null, -1, null, note_publisher, -1)==null) return false;
		
		//���� Dao �㷽��
		//����ʧ�ܷ��� false
		//��֮���� true
		return (this.noteDao.updateNote( note_id, -1, null, -1, null , 1) == null) ? false:true;
		
	}


	@Override
	public boolean postNote(String note_name, int note_type, String note_content, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//���� Dao �㷽��
		//����ʧ�ܷ��� false
		//��֮���� true
		return ( this.noteDao.createNote(note_name, note_type, note_content, note_publisher) == null) ? false:true;
	}


	@Override
	public boolean deleteNote(int note_id, int note_publisher) {
		
		this.noteDao = new NoteDaoImpl();
		
		//���û�Ǹù���Ա�����Ļ�
		//����false
		if( this.noteDao.findNoteM(note_id, null, -1, null, note_publisher, -1)==null ) return false;
		
		//����Dao��ط���ɾ����Ϣ
		return this.noteDao.deleteNote(note_id);
	}
	
}