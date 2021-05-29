package com.itbulls.learnit.javacore.patterns.behavioral.state;

public class Document {
	
	private State state;
	private String createdByNickname;
	private String moderatedByNickname;
	private String publishedByNickname;
	
	public Document() {
		this.state = new DraftState(this);
	}
	
	public void publish(User user) {
		this.state.publish(user);
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setPublishedByNickname(String nickname) {
		this.publishedByNickname = nickname;
	}

	public void setModeratedByNickname(String nickname) {
		this.moderatedByNickname = nickname;
	}

	public void setCreatedByNickname(String nickname) {
		this.createdByNickname = nickname;
	}

	public void printStatus() {
		System.out.println("===== Document Status =====");
		System.out.println("Created by: " + this.createdByNickname);
		System.out.println("Moderated by: " + this.moderatedByNickname);
		System.out.println("Published by: " + this.publishedByNickname);
		System.out.println("State: " + this.state.toString());
		System.out.println("============================");
		
	}

}
