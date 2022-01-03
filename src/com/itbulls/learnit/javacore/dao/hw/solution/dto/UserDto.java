package com.itbulls.learnit.javacore.dao.hw.solution.dto;

import java.math.BigDecimal;

public class UserDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private RoleDto roleDto;
	private BigDecimal money;
	private String creditCard;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RoleDto getRoleDto() {
		return roleDto;
	}
	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
