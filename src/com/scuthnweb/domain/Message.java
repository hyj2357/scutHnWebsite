package com.scuthnweb.domain;

public class Message extends com.scuthnweb.domain.BaseDomain{
       private int     message_id;
       private String  message_content;
       
	public int getMessage_id() {
		return message_id;
	}
	
	public void setMessage_id(int  message_id) {
		this.message_id = message_id;
	}
	
	public String getMessage_content() {
		return message_content;
	}
	
	public void setMessage_content(String  message_content) {
		this.message_content = message_content;
	}
	
}
