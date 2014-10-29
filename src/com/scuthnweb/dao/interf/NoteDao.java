package com.scuthnweb.dao.interf;

import java.util.List;

import com.scuthnweb.domain.Note;

public interface NoteDao {
	/**
	 * 
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public Note createNote( String note_name,
			                int    note_type,
			                String note_content,
			                int    note_publisher);
	
	
	/**
	 * Jun:条件式更新信息表
	 * @param note_id
	 * @param note_idM
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @return
	 */
	public Note updateNote( int    note_id,
			                int    note_idM,
			                String note_name,
                            int    note_type,
                            String note_content,
                            int    note_state);
	
	
	/**
	 * Jun:条件式查找信息表
	 * @param note_id
	 * @param note_name
	 * @param note_type
	 * @param note_content
	 * @param note_publisher
	 * @return
	 */
	public List<Note> findNoteM( int    note_id,
                           String note_name,
                           int    note_type,
                           String note_content,
                           int    note_publisher,
                           int    note_state);
	
	/**
	 * 
	 * @param note_id
	 * @return
	 */
	public List<Note> findByNote_id( int note_id );

	
	/**
	 * Jun:删除信息
	 * @param note_id
	 * @return
	 */
	public boolean deleteNote( int note_id );
}
