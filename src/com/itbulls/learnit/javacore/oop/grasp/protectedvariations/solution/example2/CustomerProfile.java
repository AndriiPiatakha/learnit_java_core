package com.itbulls.learnit.javacore.oop.grasp.protectedvariations.solution.example2;

//Clean internal model used by our system.
//No legacy field names or legacy concepts leak here.

public class CustomerProfile {

	public enum Segment {
		VIP, STANDARD
	}

	private final String email;
	private final Segment segment;

	public CustomerProfile(String email, Segment segment) {
		this.email = email;
		this.segment = segment;
	}

	public String getEmail() {
		return email;
	}

	public Segment getSegment() {
		return segment;
	}
}
