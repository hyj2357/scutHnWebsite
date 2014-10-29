package com.scuthnweb.domain;

public class Share_link {
	
	private int share_link_id, share_link_publisher, share_link_state;
		
	private String share_link_name, share_link_content;
	
	public  Share_link(){};
	
	
	public int getShare_link_id() {
		return share_link_id;
	}
	public void setShare_link_id(int share_link_id) {
		this.share_link_id = share_link_id;
	}
	
	
	
	public int getShare_link_publisher() {
		return share_link_publisher;
	}
	public void setShare_link_publisher(int share_link_publisher) {
		this.share_link_publisher = share_link_publisher;
	}
	
	
	public int getShare_link_state() {
		return share_link_state;
	}
	public void setShare_link_state(int share_link_state) {
		this.share_link_state = share_link_state;
	}
	
	
	public String getShare_link_name() {
		return share_link_name;
	}
	public void setShare_link_name(String share_link_name) {
		this.share_link_name = share_link_name;
	}
	
	
	public String getShare_link_content() {
		return share_link_content;
	}
	public void setShare_link_content(String share_link_content) {
		this.share_link_content = share_link_content;
	}		
}
