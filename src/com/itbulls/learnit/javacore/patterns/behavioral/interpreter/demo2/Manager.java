package com.itbulls.learnit.javacore.patterns.behavioral.interpreter.demo2;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Manager extends Employee {

	List<Employee> managingEmployees = new ArrayList<Employee>();

	public Manager(long employeeId, String employeeName, String designation, Department department, int salary) {
		super(employeeId, employeeName, designation, department, salary);
	}

	public boolean manages(Employee employee) {
		return managingEmployees.add(employee);
	}

	public boolean stopManaging(Employee employee) {
		return managingEmployees.remove(employee);
	}

	public List<Employee> getManagingEmployees() {
		return managingEmployees;
	}

	@Override
	public int teamSize() {
		return managingEmployees.stream().mapToInt(employee -> employee.teamSize()).sum();
	}

	@Override
	public boolean isManager() {
		return true;
	}

	@Override
	public String teamNames() {
		StringBuilder builder = new StringBuilder();
		builder.append("{").append(String.join(", ", managingEmployees.stream().map(employee -> {
			if (employee.isManager()) {
				return employee.getEmployeeName() + " " + employee.teamNames();
			} else {
				return employee.getEmployeeName();
			}
		}).collect(Collectors.toList()))).append("}");
		return builder.toString();
	}
}