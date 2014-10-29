package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Note;

public interface NoteModule{
	
	/**
	 * Jun: �鿴������Ϣ
	 * @validate no
	 * @interrupt no	
	 * @return
	 */
	public  List<Note> checkAllNote( boolean isAdmin );
	
	/**
	 * Jun:�鿴���˷�������Ϣ
	 * @validate no
	 * @interrupt yes  
	 * @param note__publisher
	 * @return
	 */
	public  List<Note> checkPostNote( int note__publisher );
	
	
	/**
	 * Jun:�޸ķ�������Ϣ
	 * @validate yes
	 * @interrupt yes
	 * @param note_id
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public  boolean    modifyNote( int note_id, String note_name, int note_type, String note_content, int note_publisher);
	
	
	/**
	 * Jun:������Ϣ
	 * @validate no
	 * @interrupt yes
	 * @param note_id
	 * @return
	 */
	public  boolean    offlineNote( int note_id, int note_publisher);
	
	
	/**
	 * Jun: ������Ϣ
	 * @validate yes
	 * @interrupt yes
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public  boolean    postNote( String note_name, int note_type, String note_content, int note_publisher);


	/**
	 * Jun: ɾ����Ϣ
	 * @validate no
	 * @interrupt yes 
	 * @param note_id
	 * @param note_publisher
	 * @return
	 */
    public  boolean  deleteNote( int note_id, int note_publisher);
}
