package com.itbulls.learnit.javacore.mockito;

public class Email {

	private String msgContent;
	private String addressee;
	
	public void setContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getAddressee() {
		return this.addressee;
	}

}
