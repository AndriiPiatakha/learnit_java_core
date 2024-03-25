package com.itbulls.learnit.javacore.oop.solid.hw.isprefactoring.task;

/*

In this file you can find violation of Interface Segregation Principle. 
You should refactor this file. 
You can remove this file completely, because it will not be used during the evaluation of the solution.

Exercise: Interface Segregation Principle (ISP) Practice

Objective:

Learn to apply Interface Segregation Principle (ISP) in Java to improve class design by separating interfaces for specific behaviors.

Instructions:

Understanding ISP: Read about the Interface Segregation Principle (ISP) to understand its importance in object-oriented design.

Review Original Code: Examine the provided original code in Java, which violates ISP by having a single interface with multiple methods, some of which might not be applicable to all implementing classes.

Identify Violations: Identify which methods in the original Worker interface are not applicable to certain implementing classes (for example for Robot class).

Refactor Code: Refactor the original code to adhere to ISP by segregating the interface into smaller, more focused interfaces for specific behaviors.

NOTE: evaluation tests rely on the console output. So, make sure that you use proper String objects when printing text to the console from relevant methods: 

Employee is working

Employee is eating

Employee is sleeping

Robot is working

Stick to the original methods naming: work(), eat(), sleep().

The source code of my solution is located here - https://github.com/AndriiPiatakha/learnit_java_core/tree/master/src/com/itbulls/learnit/javacore/oop/solid/hw/isprefactoring

*/

//Client code
public class Demo {
	public static void main(String[] args) {
		Worker employee = new Employee();
		employee.work();
		employee.eat();
		employee.sleep();
	}
}

//Original interface violating ISP
interface Worker {
	void work();

	void eat();

	void sleep();
}

//Original class implementing the interface
class Employee implements Worker {
	@Override
	public void work() {
		System.out.println("Employee is working");
	}

	@Override
	public void eat() {
		System.out.println("Employee is eating");
	}

	@Override
	public void sleep() {
		System.out.println("Employee is sleeping");
	}
}


class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }

    @Override
    public void eat() {
        // This method doesn't make sense for a robot
        // Implementation might not be meaningful
    }

    @Override
    public void sleep() {
        // This method doesn't make sense for a robot
        // Implementation might not be meaningful
    }
}