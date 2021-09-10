package com.itbulls.learnit.javacore.annotations;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	@SuppressWarnings(value = "rawtypes")
//	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List list = new ArrayList();
	}
	
	
	@Override
	@Author(name = "Vladymyr Vysotskiy")
	@Author(name = "Konstantin Simonov")
	public String toString() {
		return "Demo [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
