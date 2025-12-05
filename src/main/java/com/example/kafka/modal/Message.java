package com.example.kafka.modal;

public class Message {

	public Message(String id, String messagecontent, String sender) {
		super();
		this.id = id;
		this.messagecontent = messagecontent;
		this.sender = sender;
	}

	public Message() {
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	private String id;
	
	private String messagecontent;
	
	private String sender;
}
