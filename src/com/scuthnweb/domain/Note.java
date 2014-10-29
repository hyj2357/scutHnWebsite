package com.scuthnweb.domain;

public class Note {
	private int note_id, note_type, note_publisher, note_state;
	
	private String note_name, note_content;
	
	
	public  Note(){};
	
	
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	
	
	public int getNote_type() {
		return note_type;
	}
	public void setNote_type(int note_type) {
		this.note_type = note_type;
	}
	
	
	public int getNote_publisher() {
		return note_publisher;
	}
	public void setNote_publisher(int note_publisher) {
		this.note_publisher = note_publisher;
	}
	
	
	public String getNote_name() {
		return note_name;
	}
	public void setNote_name(String note_name) {
		this.note_name = note_name;
	}
	
	
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}


	public int getNote_state() {
		return note_state;
	}


	public void setNote_state(int note_state) {
		this.note_state = note_state;
	}
}
