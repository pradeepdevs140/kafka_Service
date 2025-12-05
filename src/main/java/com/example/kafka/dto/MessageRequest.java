package com.example.kafka.dto;

public class MessageRequest {
	private String messagecontent;
	
	public MessageRequest(String messagecontent, String sender) {
		super();
		this.messagecontent = messagecontent;
		this.sender = sender;
	}
	public MessageRequest() {
		
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

	private String sender;

}
