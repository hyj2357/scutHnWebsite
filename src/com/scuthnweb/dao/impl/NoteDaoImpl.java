package com.scuthnweb.dao.impl;

import java.util.List;

import com.scuthnweb.dao.interf.NoteDao;
import com.scuthnweb.domain.Note;

public class NoteDaoImpl implements NoteDao{

	public Note createNote(String note_name, int note_type, String note_content, int note_publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Note> findByNote_id(int note_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note updateNote(int note_id, int note_idM, String note_name,
			int note_type, String note_content, int  note_state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> findNoteM(int note_id, String note_name, int note_type,
			String note_content, int  note_publisher, int note_state) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteNote(int note_id) {
		// TODO Auto-generated method stub
		return false;
	}

}
