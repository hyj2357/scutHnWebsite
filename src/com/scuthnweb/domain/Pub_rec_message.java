package com.scuthnweb.domain;

public class Pub_rec_message extends com.scuthnweb.domain.BaseDomain{
	
	private int message_receiver,
                message_publisher,
	            message_id;
	
	public   Pub_rec_message(){};
	

	public int getMessage_receiver() {
		return message_receiver;
	}

	public void setMessage_receiver(int message_receiver) {
		this.message_receiver = message_receiver;
	}

	public int getMessage_publisher() {
		return message_publisher;
	}

	public void setMessage_publisher(int message_publisher) {
		this.message_publisher = message_publisher;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	
	
	
}
