package com.itbulls.learnit.javacore.oop.grasp.infoexpert.problem.example1;

import java.util.List;

//Passive data holders, no real behavior
public class Order {
	private List<OrderLine> lines;

	public List<OrderLine> getLines() {
		return lines;
	}
}
