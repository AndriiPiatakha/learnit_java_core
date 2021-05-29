package com.itbulls.learnit.javacore.patterns.behavioral.state;

public class DraftState extends DocumentState {
	
	
	public DraftState(Document document) {
		super(document);
	}

	@Override
	public void publish(User user) {
		document.setCreatedByNickname(user.getNickname());
		document.setState(new InModerationState(document));
		System.out.println("Document is sent to moderation");
	}

	@Override
	public String toString() {
		return "Draft State";
	}
	
	
	

}
