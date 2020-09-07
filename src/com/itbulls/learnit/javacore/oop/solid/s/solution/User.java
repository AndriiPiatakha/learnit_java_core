package com.itbulls.learnit.javacore.oop.solid.s.solution;

public class User {

	private int id;
	private String primaryEmail;
	private String secondaryEmail;
	private Role role;

	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	
	public void setSecondaryEmail(String newSecondaryEmail) {
		this.secondaryEmail = newSecondaryEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public void sendMoney(User userTo, int dollarsAmount) {
		// some code here to transfer money
	}

	public Role getRole() {
		return this.role;
	}

}
