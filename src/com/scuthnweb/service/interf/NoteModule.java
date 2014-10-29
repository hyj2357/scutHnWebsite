package com.scuthnweb.service.interf;

import java.util.List;

import com.scuthnweb.domain.Note;

public interface NoteModule{
	
	/**
	 * Jun: 查看所有信息
	 * @validate no
	 * @interrupt no	
	 * @return
	 */
	public  List<Note> checkAllNote( boolean isAdmin );
	
	/**
	 * Jun:查看本人发布的信息
	 * @validate no
	 * @interrupt yes  
	 * @param note__publisher
	 * @return
	 */
	public  List<Note> checkPostNote( int note__publisher );
	
	
	/**
	 * Jun:修改发布的信息
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
	 * Jun:下线信息
	 * @validate no
	 * @interrupt yes
	 * @param note_id
	 * @return
	 */
	public  boolean    offlineNote( int note_id, int note_publisher);
	
	
	/**
	 * Jun: 发布信息
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
	 * Jun: 删除信息
	 * @validate no
	 * @interrupt yes 
	 * @param note_id
	 * @param note_publisher
	 * @return
	 */
    public  boolean  deleteNote( int note_id, int note_publisher);
}
