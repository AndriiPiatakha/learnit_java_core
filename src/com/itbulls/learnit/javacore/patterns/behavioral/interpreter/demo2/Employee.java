package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2;

public abstract class Employee {

	protected long employeeId;
	protected String employeeName;
	protected String designation;
	protected Department department;
	protected int salary;

	public Employee(long employeeId, String employeeName, String designation, Department department, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.department = department;
		this.salary = salary;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public abstract int teamSize();

	public abstract String teamNames();

	public abstract boolean isManager();

	public String fullDetails() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [").append(employeeId).append(", ").append(employeeName).append(", ")
				.append(designation).append(", ").append(department).append(", ").append(salary).append(", TeamSize=")
				.append(teamSize()).append(", Team=").append(teamNames()).append("]");
		return builder.toString();
	}

	public String shortDetails() {
		StringBuilder builder = new StringBuilder();
		builder.append("'").append(employeeName).append("'");
		return builder.toString();
	}

	@Override
	public String toString() {
		return fullDetails();
	}

}