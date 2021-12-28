package com.itbulls.learnit.javacore.dao.dto;

public class RoleDto {

	private int id;
	private String roleNmae;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleNmae() {
		return roleNmae;
	}
	public void setRoleNmae(String roleNmae) {
		this.roleNmae = roleNmae;
	}
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", roleNmae=" + roleNmae + "]";
	}
	
}
