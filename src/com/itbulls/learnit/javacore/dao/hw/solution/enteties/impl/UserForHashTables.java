package com.itbulls.learnit.javacore.dao.hw.solution.enteties.impl;

import java.util.Objects;

import com.itbulls.learnit.javacore.dao.hw.solution.enteties.User;

public class UserForHashTables implements User {
	
	private static int userCounter = 0;
	
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String roleName;
	private double money;
	private String creditCard;

	{
		id = ++userCounter;
	}
	
	public UserForHashTables() {
	}
	
	public UserForHashTables(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	
	public UserForHashTables(int id, String firstName, String lastName, String password, String email) {
		this.id = id;
		userCounter--; // to keep sequantial id
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + "\t\t" +
				"First Name: " + this.getFirstName() + "\t\t" +
				"Last Name: " + this.getLastName() + "\t\t" +
				"Email: " + this.getEmail();
	}

	@Override
	public void setPassword(String password) {
		if (password == null) {
			return;
		}
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		if (newEmail == null) {
			return;
		}
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	void clearState() {
		userCounter = 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserForHashTables other = (UserForHashTables) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getRoleName() {
		return this.roleName;
	}

	@Override
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String getCreditCard() {
		return this.creditCard;
	}

	@Override
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
}
